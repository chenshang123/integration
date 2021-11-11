package team.sun.integration.modules.sys.security.utils;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class JwtSecurityUtil {

    /**
     * 获取当前用户ID
     */
    public static Optional<String> getCurrentUserID() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx != null &&
                ctx.getAuthentication() != null &&
                ctx.getAuthentication().getPrincipal() != null) {
            Object principal = ctx.getAuthentication().getPrincipal();
            if (principal instanceof UserDetails userDetails) {
                return Optional.ofNullable(userDetails.getUsername());
            }
        }
        return Optional.empty();
    }
}
