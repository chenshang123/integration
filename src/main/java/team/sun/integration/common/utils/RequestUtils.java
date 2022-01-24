package team.sun.integration.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * request工具类
 *
 * @author gsl
 */
public final class RequestUtils {

    private RequestUtils() {
    }

    /**
     * 获取当前服务器访问url
     *
     * @param request 请求
     * @return url
     */
    public static String getServerUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request
                .getContextPath();
    }

    /**
     * 获取当前 URL 包含查询条件
     *
     * @param charset URLEncoder编码格式
     */
    public static String getQueryString(HttpServletRequest request, Charset charset) {
        StringBuilder sb = new StringBuilder(request.getRequestURL());
        String query = request.getQueryString();
        if (query != null && query.length() > 0) {
            sb.append("?").append(query);
        }
        try {
            return URLEncoder.encode(sb.toString(), charset.name());
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * url是否在请求内
     *
     * @param request 请求
     * @param url     参数为以';'分割的URL字符串
     * @return 是否存在
     */
    public static boolean containUrl(HttpServletRequest request, String url) {
        boolean result = false;
        if (url != null && !"".equals(url.trim())) {
            String[] urlArr = url.split(";");
            StringBuilder reqUrl = new StringBuilder(request.getRequestURL());
            for (String anUrlArr : urlArr) {
                if (reqUrl.indexOf(anUrlArr) > 1) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 获取当前完整请求地址
     *
     * @return 请求地址
     */
    public static String getRequestUrl(HttpServletRequest request) {
        StringBuilder url = new StringBuilder(request.getScheme())
                .append("://")
                .append(request.getHeader("host"))
                .append(request.getRequestURI());
        if (request.getQueryString() != null) {
            url.append("?").append(request.getQueryString());
        }
        return url.toString();
    }

    /**
     * 获取Request PlayLoad 内容
     *
     * @return Request PlayLoad 内容
     */
    public static String requestPlayLoad(HttpServletRequest request) throws IOException {
        try (InputStream inputStream = request.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder sb = new StringBuilder();
            char[] charBuffer = new char[128];
            int bytesRead;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                sb.append(charBuffer, 0, bytesRead);
            }
            return sb.toString();
        }
    }

}
