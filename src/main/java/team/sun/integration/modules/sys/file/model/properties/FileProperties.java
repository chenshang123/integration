package team.sun.integration.modules.sys.file.model.properties;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import team.sun.integration.config.base.enums.ret.BusRetEnum;
import team.sun.integration.config.base.exception.UploadException;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;

@Component
@ConfigurationProperties("file")
public class FileProperties {

    //"rar","zip","arj","gz","z",
    // "bmp","gif","jpg","pic","png","tif",
    // "doc","docx","ppt","pptx","xls","xlsx",
    //"pdf"
    Set<String> allowImgExtName =
            ImmutableSet.of("gif","jpg","png");
    Set<String> allowOfficeExtName =
            ImmutableSet.of("doc", "docx", "ppt", "pptx", "xls", "xlsx", "pdf");

    /**
     * 文件上传地址
     */
    private String uploadPath;

    /**
     * 文件缓存地址
     */
    private String tempPath;

    /**
     * 上传单个文件的大小的最大值
     */
    private Long fileSizeMax;

    /**
     * 上传文件总量的最大值
     */
    private Long sizeMax;

    /**
     * 数据解析编码
     */
    private String codeSet;

    private final String slash = File.separator;

    public String getPathSpacer() {
        return "_";
    }

    private void rewriteImg(InputStream inputStream, String filePath) throws IOException {
        if (inputStream == null) {
            return;
        }
        BufferedImage src = ImageIO.read(inputStream);
        int old_w = src.getWidth();
        // 得到源图宽
        int old_h = src.getHeight();
        // 得到源图长
        BufferedImage newImg;
        // 判断输入图片的类型
        if (src.getType() == 13) {// png,gif
            newImg = new BufferedImage(old_w, old_h, BufferedImage.TYPE_4BYTE_ABGR);
        } else {
            newImg = new BufferedImage(old_w, old_h, BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D g = newImg.createGraphics();
        // 从原图上取颜色绘制新图
        g.drawImage(src, 0, 0, old_w, old_h, null);
        g.dispose();
        // 根据图片尺寸压缩比得到新图的尺寸
        newImg.getGraphics().drawImage(
                src.getScaledInstance(old_w, old_h, Image.SCALE_SMOOTH), 0,0, null);
        File newFile = new File(filePath);
        String formatName = filePath.substring(filePath.lastIndexOf(".")+1).toLowerCase();
        ImageIO.write(newImg, formatName, newFile);

    }

    public List<FileEntity> upload(HttpServletRequest request) throws FileUploadException, IOException {
        List<FileEntity> fileEntities = new ArrayList<>();

        String tempPath = this.getTempPath();
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            if (!tmpFile.mkdirs()){
                throw new UploadException(BusRetEnum.BUS_FILE_PATH_ERROR.getMsg());
            }
        }
        String message = null;
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
        upload.setHeaderEncoding(this.getCodeSet());
        upload.setFileSizeMax(this.getFileSizeMax());
        upload.setSizeMax(this.getSizeMax());
        // 3、判断提交上来的数据是否是上传表单的数据
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 按照传统方式获取数据

        }
        // 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的
        List<FileItem> list = upload.parseRequest(request);

        byte[] fileBytes;
        String uuid = this.makeUUID();
        for (FileItem item : list) {
            if (item.isFormField()) {
                //普通输入项的数据，暂时不处理

            } else {
                String filename = item.getName();
                if(StringUtils.hasLength(filename) && filename.length() > 50){
                    throw new UploadException(BusRetEnum.BUS_FILE_NAME_SUPER_LONG.getMsg());
                }
                // 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的
                InputStream in = item.getInputStream();
                fileBytes = this.InputStreamToByte(in);
                in.close();
                item.delete();
                FileEntity fileEntity = this.makeFileEntity(uuid, filename);
                // 文件类型是否合法
                if(this.extNameCheck(filename, this.getAllowImgExtName())){
                    fileEntities.add(this.saveImg(fileEntity, fileBytes));
                }else{
                    throw new UploadException(BusRetEnum.BUS_FILE_TYPE_NOT_SUPPORTED.getMsg());
                }
            }
        }
        return fileEntities;

    }

    /**
     * download 1. 将文件以流的形式一次性读取到内存，通过响应输出流输出到前端
     */
    public void download(String path, HttpServletResponse response) {
        try {
            // path是指想要下载的文件的路径
            File file = new File(path);
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            //String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            int total = fis.read(buffer);
            fis.close();
            if(total < 1){
                response.sendError(404, "File not found!");
                return;
            }

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * download 2. 将输入流中的数据循环写入到响应输出流中，而不是一次性读取到内存，通过响应输出流输出到前端
     */
    public void downloadLocal(String path, HttpServletResponse response) throws IOException  {
        // 读到流中
        InputStream inputStream = new FileInputStream(path);// 文件的存放路径
        response.reset();
        response.setContentType("application/octet-stream");
        String filename = new File(path).getName();
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        //从输入流中读取一定数量的字节，并将其存储在缓冲区字节数组中，读到末尾返回-1
        while ((len = inputStream.read(b)) > 0) {
            outputStream.write(b, 0, len);
        }
        inputStream.close();
    }

    /**
     * download 3. 下载网络文件到本地
     * path 下载后的文件路径和名称
     * netAddress 文件所在网络地址
     */
    public void downloadNet(String path, String netAddress) throws IOException {
        URL url = new URL(netAddress);
        URLConnection conn = url.openConnection();
        InputStream inputStream = conn.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        int byteSum = 0;
        int byteRead;
        byte[] buffer = new byte[1024];
        while ((byteRead = inputStream.read(buffer)) != -1) {
            byteSum += byteRead;
            System.out.println(byteSum);
            fileOutputStream.write(buffer, 0, byteRead);
        }
        fileOutputStream.close();
    }

    /**
     * download 4. 网络文件获取到服务器后，经服务器处理后响应给前端
     * netAddress 网络文件地址
     * filename 文件名称
     * isOnLine 是否在线预览
     * response
     */
    public void netDownLoadNet(String netAddress, String filename, boolean isOnLine, HttpServletResponse response) throws Exception {

        URL url = new URL(netAddress);
        URLConnection conn = url.openConnection();
        InputStream inputStream = conn.getInputStream();

        response.reset();
        response.setContentType(conn.getContentType());
        if (isOnLine) {
        // 在线打开方式 文件名应该编码成UTF-8
            response.setHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
        } else {
        //纯下载方式 文件名应该编码成UTF-8
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
        }

        byte[] buffer = new byte[1024];
        int len;
        OutputStream outputStream = response.getOutputStream();
        while ((len = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        inputStream.close();
    }

    /**
     * 文件后缀名-验证
     */
    public boolean extNameCheck(String filename, Set<String> allowExtName){
        if (filename != null && !filename.trim().equals("")) {
            filename = filename.substring(filename.lastIndexOf("\\") + 1);
            // 得到上传文件的扩展名
            String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
            return StringUtils.hasLength(fileExtName) && allowExtName.contains(fileExtName);
        }
        return false;
    }

    /**
     * 给文件路径组装时间隔断
     */
    private String makeTimePartition() {
        LocalDate now = LocalDate.now();
        return now.getYear() +
                this.getPathSpacer() +
                now.getMonthValue() +
                this.getPathSpacer() +
                now.getDayOfMonth();
    }

    public String makeUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     *为文件名组装uuid
     */
    private String makeFileName(String uuid, String fileName) {
        // 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return uuid + "_" + fileName;
    }

    /**
     * 组装文件全路径，并创建文件目录
     */
    private String makeSavePath(FileEntity entity){
        String dirs = this.getUploadPath() + this.getSlash() +
                entity.getStorageUrl().replaceAll(this.getPathSpacer(), Matcher.quoteReplacement(this.getSlash()));
        File file = new File(dirs);
        if (!file.exists()) {
            if (!file.mkdirs()){
                throw new UploadException(BusRetEnum.BUS_FILE_PATH_ERROR.getMsg());
            }
        }
        return  dirs + this.getSlash() + entity.getName();
    }
    /**
     * 把InputStream首先转换成byte[].
     */
    public byte[] InputStreamToByte(InputStream source) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = source.read(buffer)) > -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 组装文件保存实体
     */
    public FileEntity makeFileEntity(String uuid, String filename){
        // 文件上传成功后，将对应的信息保存到数据库SYS_FILE表
        FileEntity entity = new FileEntity();
        entity.setName(makeFileName(uuid, filename));
        entity.setStorageUrl(makeTimePartition());
        entity.setBusinessId(uuid);
        return entity;
    }

    /**
     * 保存文件到指定目录，并返回文件详情对象
     */
    public FileEntity saveImg(FileEntity entity, byte[] fileBytes) throws IOException {
        this.rewriteImg(new ByteArrayInputStream(fileBytes), this.makeSavePath(entity));
        entity.setSize(fileBytes.length);
        return entity;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getTempPath() {
        return tempPath;
    }

    public void setTempPath(String tempPath) {
        this.tempPath = tempPath;
    }

    public Long getFileSizeMax() {
        return fileSizeMax;
    }

    public void setFileSizeMax(Long fileSizeMax) {
        this.fileSizeMax = fileSizeMax;
    }

    public Long getSizeMax() {
        return sizeMax;
    }

    public void setSizeMax(Long sizeMax) {
        this.sizeMax = sizeMax;
    }

    public String getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(String codeSet) {
        this.codeSet = codeSet;
    }

    public Set<String> getAllowImgExtName() {
        return allowImgExtName;
    }

    public Set<String> getAllowOfficeExtName() {
        return allowOfficeExtName;
    }

    public String getSlash() {
        return slash;
    }

}
