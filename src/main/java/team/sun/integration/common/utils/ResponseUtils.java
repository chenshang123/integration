package team.sun.integration.common.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.sun.integration.common.web.log.LogAspect;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * 提供response输出的实用方法集
 *
 * @author TaoYu
 */
public final class ResponseUtils {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    private ResponseUtils() {
    }


    /**
     * 后台数据以json方式输出到前台
     */
    public static void writeJson(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        writer(response, obj);
    }

    /**
     * ajax跨域请求jsonP
     */
    public static void writeJsonP(HttpServletRequest request, HttpServletResponse response,
                                  Object obj)
            throws IOException {
        String callback = request.getParameter("callback");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-store");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter out = response.getWriter()) {
            String jsonString = JacksonUtil.toJson(obj);
            if (StringUtils.isEmpty(callback)) {
                out.write(jsonString);
            } else {
                out.write(callback + "(" + jsonString + ")");
            }
            out.flush();
        }
    }

    /**
     * 输出html
     */
    public static void writeHtml(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        writer(response, obj);

    }

    /**
     * 一般用于输出Image图片
     */
    public static void writeImage(HttpServletResponse response, byte[] byteArray) throws IOException {
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0);
        response.setContentType(MediaType.IMAGE_GIF_VALUE);
        try (OutputStream out = response.getOutputStream()) {
            out.write(byteArray);
            out.flush();
        }
    }

    /**
     * 一般用于输出Gif图片
     */
    public static void writeGif(HttpServletResponse response, byte[] byteArray) throws IOException {
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0);
        response.setContentType(MediaType.IMAGE_GIF_VALUE);
        try (ByteArrayInputStream in = new ByteArrayInputStream(byteArray);
             OutputStream out = response.getOutputStream()) {
            BufferedImage img = ImageIO.read(in);
            ImageIO.write(img, "gif", out);
        }
    }

    /**
     * 内部的通用输出
     */
    private static void writer(HttpServletResponse response, Object obj) throws IOException {
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter out = response.getWriter()) {
            out.print(JacksonUtil.toJson(obj));
            out.flush();
        }
    }

    /**
     * 允许 JS 跨域设置
     */
    public static void allowJsCrossDomain(HttpServletResponse response) {
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS, POST, PUT, DELETE");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
    }

}
