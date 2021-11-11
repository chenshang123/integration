package team.sun.integration.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * web工具类
 *
 * @author TaoYu MaYing
 */
public final class WebUtils {

    /**
     * 当前请求
     */
    public static HttpServletRequest request() {
        return contextHolder() == null ? null : contextHolder().getRequest();
    }

    /**
     * 当前响应
     */
    public static HttpServletResponse response() {
        return contextHolder() == null ? null : contextHolder().getResponse();
    }

    /**
     * 当前session
     */
    public static HttpSession session() {
        return request() == null ? null : request().getSession();
    }

    /**
     * 当前ServletRequest
     */
    public static ServletRequestAttributes contextHolder() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 判断请求是否为 AJAX
     *
     * @param request 当前请求
     */
    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

}
