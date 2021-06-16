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
/*
  private WebUtils() {
  }

  public static <T extends UserDetail> void saveUser(T user) {
    session().setAttribute("currentUser", user);
  }

  public static <T extends UserDetail> UserDetail user() {
    if(null != session() && null != session().getAttribute("currentUser")){
      return (UserDetail)session().getAttribute("currentUser");
    }
    return null;
  }

  public static String username() {
    UserDetail user = user();
    return user == null ? null : user.getUsername();
  }

  public static Long userId() {
    UserDetail user = user();
    return user == null ? null : user.getUserId();
  }
*/

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
