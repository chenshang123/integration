package team.sun.integration.common.utils;

import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Cookie工具类
 * <pre>
 * Cookie的常用操作
 * </pre>
 *
 * @author TaoYu
 */
public final class CookieUtils {

    public static final int COOKIE_MAX_AGE = 7 * 24 * 3600;

    public static final int COOKIE_HALF_HOUR = 30 * 60;

    private CookieUtils() {
    }

    /**
     * 添加cookie,Https下使用 FIXME 未经过加密，不安全。待修复，选择适合的加密算法
     *
     * @param response 响应
     * @param name     名称
     * @param value    值
     * @param maxAge   存活时间
     */
    public static void addCookie(HttpServletResponse response, String name, String value,
                                 int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(Math.abs(maxAge));
        response.addCookie(cookie);
    }

    /**
     * 添加cookie，Https下使用
     *
     * @param response 响应
     * @param name     名称
     * @param value    值
     * @param maxAge   存活时间
     */
    public static void addSSLCookie(HttpServletResponse response, String name, String value,
                                    int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setSecure(true);
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * @param request 请求
     * @param name    cookie名
     * @return cookie值
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isNotEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if (Objects.equals(name, cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * 移除cookie
     *
     * @param name 这个是名称，不是值
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response,
                                    String name) {
        if (null == name) {
            return;
        }
        Cookie cookie = getCookie(request, name);
        if (null != cookie) {
            addCookie(response, name, "", 0);
        }
    }

}
