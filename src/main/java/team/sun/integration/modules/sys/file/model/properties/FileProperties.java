package team.sun.integration.modules.sys.file.model.properties;

import com.google.common.collect.ImmutableSet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import team.sun.integration.config.base.enums.ret.BusRetEnum;
import team.sun.integration.config.base.exception.UploadException;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
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
        //if(newFile.mkdirs() && newFile.createNewFile()){
            String formatName = filePath.substring(filePath.lastIndexOf(".")+1).toLowerCase();
            ImageIO.write(newImg, formatName, newFile);
        //}

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
