package team.sun.integration.modules.sys.file.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import team.sun.integration.modules.sys.file.model.properties.FileProperties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@WebServlet("/downLoad")
public class DownloadServlet extends HttpServlet {

    private final FileProperties fileProperties;

    @Autowired(required = false)
    public DownloadServlet(FileProperties fileProperties){
        this.fileProperties = fileProperties;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        try {
            List<FileItem> list = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : list) {
            //如果是文本
                if (fileItem.isFormField()) {
/*                  String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");*/
                } else {
                    //文件
                    InputStream inputStream = fileItem.getInputStream();

                    String path = req.getServletContext().getRealPath("/file/" + fileItem.getName());
                    path = new String(path.getBytes("ISO8859-1"), "UTF-8");
                    path = "C:\\Users\\SH0033\\Desktop\\abcd.doc";
                    //*告诉客户端这个文件不是解析 而是以附件的形式下载
                    String realName = "abcd.doc";
                    resp.setHeader("content-disposition", "attachment;filename="
                            + URLEncoder.encode(realName, "UTF-8"));
                    OutputStream outputStream = new FileOutputStream(path);
                    int temp;
                    while ((temp = inputStream.read()) != -1) {
                        outputStream.write(temp);
                    }
                    outputStream.close();
                    inputStream.close();
                    System.out.println("输出成功");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
