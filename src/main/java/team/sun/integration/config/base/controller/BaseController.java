package team.sun.integration.config.base.controller;

import team.sun.integration.common.exception.DownloadException;
import org.springframework.http.MediaType;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

/**
 * 抽象顶层公共控制层
 * <pre>
 * 简化了常用的返回结果和跳转
 * 继承了文件抽象控制层
 * </pre>
 *
 * @author TaoYu
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    /**
     * 字符串转发页面
     *
     * @param view 页面地址
     */
    protected ModelAndView forward(String view) {
        return new ModelAndView("forward:" + view);
    }

    /**
     * 对象重定向页面
     *
     * @param view 页面地址
     */
    protected ModelAndView redirect(String view) {
        return new ModelAndView("redirect:" + view);
    }

    /**
     * 下载文件
     *
     * @return 下载流ResponseEntity
     * @throws DownloadException 下载错误
     */
    public ResponseEntity<FileSystemResource> download(FileSystemResource resource) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
            headers.add(HttpHeaders.PRAGMA, "no-cache");
            headers.add(HttpHeaders.EXPIRES, "0");
            headers.add(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=" + URLEncoder
                            .encode(resource.getFilename(), StandardCharsets.UTF_8.name()));
            return ResponseEntity.ok()
                    .contentLength(resource.getFile().length())
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (Exception e) {
            throw new DownloadException(e);
        }
    }

    /**
     * 下载文件
     *
     * @return 下载流ResponseEntity
     * @throws DownloadException 下载错误
     */
    public ResponseEntity<byte[]> download(String fileName, byte[] bytes) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
            headers.add(HttpHeaders.PRAGMA, "no-cache");
            headers.add(HttpHeaders.EXPIRES, "0");
            headers.add(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()));
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(bytes);
        } catch (Exception e) {
            throw new DownloadException(e);
        }
    }

}