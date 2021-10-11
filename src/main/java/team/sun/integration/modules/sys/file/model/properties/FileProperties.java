package team.sun.integration.modules.sys.file.model.properties;

import com.google.common.collect.ImmutableSet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Set;

@Component
@ConfigurationProperties("file")
public class FileProperties {

    Set<String> allowFileExtName =
            ImmutableSet.of("rar","zip","arj","gz","z",
                    "bmp","gif","jpg","pic","png","tif",
                    "doc","docx","ppt","pptx","xls","xlsx",
                    "pdf");

    Set<String> allowMimeType =
            ImmutableSet.of("image/pjpeg","application/pdf","application/msword","image/jpeg",
                    "image/x-png","image/tiff","application/vnd.ms-excel","application/zip",
                    "image/bmp","image/x-bitmap","image/x-pixmap","image/jpg",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" /*xlsx*/
                    ,"application/x-rar-compressed","application/rtf","application/x-tika-ooxml",/*xls*/
                    "application/x-bplist"/*pdf*/,"application/pdf",
                    "application/vnd.ms-word.document.macroenabled.12"/*docm*/,"application/x-tika-msoffice"/*pdf*/,
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation"/*pptx*/
                    ,"application/x-7z-compressed","application/vnd.ms-xpsdocument"/*xps*/);
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

    public Set<String> getAllowFileExtName() {
        return allowFileExtName;
    }

    public Set<String> getAllowMimeType() {
        return allowMimeType;
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

    public String getSlash() {
        return slash;
    }

    public String getPathSpacer() {
        return "_";
    }
}
