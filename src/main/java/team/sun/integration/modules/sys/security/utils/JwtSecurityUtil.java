package team.sun.integration.modules.sys.security.utils;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtSecurityUtil {

    /**
     * 获取用户信息
     */
    public static String getCurrentUserName() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx != null &&
                ctx.getAuthentication() != null &&
                ctx.getAuthentication().getPrincipal() != null) {
            Object principal = ctx.getAuthentication().getPrincipal();
            if (principal instanceof UserDetails userDetails) {
                return userDetails.getUsername();
            }
        }
        return null;
    }
}
