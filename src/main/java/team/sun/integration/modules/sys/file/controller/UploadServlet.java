package team.sun.integration.modules.sys.file.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import team.sun.integration.config.base.exception.UploadException;
import team.sun.integration.config.base.enums.ret.BusRetEnum;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;
import team.sun.integration.modules.sys.file.model.properties.FileProperties;
import team.sun.integration.modules.sys.file.service.FileService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    private final FileProperties fileProperties;
    private final FileService fileService;

    @Autowired(required = false)
    public UploadServlet(FileProperties fileProperties, FileService fileService){
        this.fileProperties = fileProperties;
        this.fileService = fileService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String tempPath = fileProperties.getTempPath();
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            if (!tmpFile.mkdir()){
                throw new UploadException(BusRetEnum.BUS_FILE_PATH_ERROR.getMsg());
            }
        }
        String message = BusRetEnum.BUS_FILE_UPLOAD_ERROR.getValue();
        try {
            // 1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个
            // 临时文件存放到指定的临时目录当中。设置缓冲区的大小为100KB，其默认大小是10KB
            factory.setSizeThreshold(1024 * 100);
            // 设置上传时生成的临时文件的保存目录
            factory.setRepository(tmpFile);
            // 2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解决上传文件名的中文乱码
            upload.setHeaderEncoding(fileProperties.getCodeSet());
            upload.setFileSizeMax(fileProperties.getFileSizeMax());
            upload.setSizeMax(fileProperties.getSizeMax());
            // 3、判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                // 按照传统方式获取数据
                return;
            }

            // 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的
            List<FileItem> list = upload.parseRequest(request);
            byte[] fileBytes;
            for (FileItem item : list) {
                if (item.isFormField()) {
                    //普通输入项的数据，暂时不处理
                    return;
                } else {
                    String filename = item.getName();
                    // 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的
                    InputStream in = item.getInputStream();
                    fileBytes = InputStreamToByte(in);
                    in.close();
                    item.delete();
                    // 文件类型是否合法
                    if(extNameCheck(filename) && mimeTypeCheck(fileBytes)){
                        saveFile(filename, fileBytes);
                    }else{
                        throw new UploadException(BusRetEnum.BUS_FILE_TYPE_NOT_SUPPORTED.getMsg());
                    }
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute(
                    "message", BusRetEnum.BUS_FILE_SINGLE_OVERRUN.getValue());
            return;
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute(
                    "message",BusRetEnum.BUS_FILE_OVERRUN.getValue());
            return;
        } catch (Exception e) {
            message = BusRetEnum.BUS_FILE_UPLOAD_ERROR.getValue();
            e.printStackTrace();
        }
        request.setAttribute("message", message);
    }

    private FileEntity saveFile(String filename, byte[] fileBytes) throws IOException {
        String timeDirectory = makeFilePath();
        String fileName = makeFileName(filename);
        String savePath = fileProperties.getUploadPath() + fileProperties.getSlash() +
                timeDirectory.replaceAll(fileProperties.getPathSpacer(), fileProperties.getSlash()) +
                fileProperties.getSlash() + fileName;
        File saveFile = new File(savePath);
        FileUtils.writeByteArrayToFile(saveFile, fileBytes);
        // 文件上传成功后，将对应的信息保存到数据库SYS_FILE表
        FileEntity entity = new FileEntity();
        entity.setName(filename);
        entity.setStorageUrl(timeDirectory);
        entity.setSize(fileBytes.length);
        //数据库插入数据
        fileService.saveOrUpdate(entity);
        return null;
    }


    /**
     * 文件后缀名-验证
     */
    private boolean extNameCheck(String filename){
        if (filename != null && filename.trim().equals("")) {
            filename = filename.substring(filename.lastIndexOf("\\") + 1);
            // 得到上传文件的扩展名
            String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
            return StringUtils.hasLength(fileExtName) && !fileProperties.getAllowFileExtName().contains(fileExtName);
        }
        return false;
    }

    final Tika tika = new Tika();
    /**
     * 文件协议类型-验证
     */
    private boolean mimeTypeCheck(byte[] sources){
        if(sources != null && sources.length > 0){
            String mimeType = tika.detect(Arrays.toString(sources));
            return fileProperties.getAllowMimeType().contains(mimeType);
        }
        return false;
    }

    private String makeFilePath() {
        LocalDate now = LocalDate.now();
        return fileProperties.getPathSpacer() +
        now.getYear() +
        fileProperties.getPathSpacer() +
        now.getMonthValue() +
        fileProperties.getPathSpacer() +
        now.getDayOfMonth();
    }

    private String makeFileName(String fileName) {
        // 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID() + "_" + fileName;
    }

    /**
     * 把InputStream首先转换成byte[].
     */
    protected byte[] InputStreamToByte(InputStream source) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = source.read(buffer)) > -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }




}
