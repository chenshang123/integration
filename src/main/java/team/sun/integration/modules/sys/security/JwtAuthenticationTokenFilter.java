package team.sun.integration.modules.sys.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import team.sun.integration.modules.base.enums.ret.BusRetEnum;
import team.sun.integration.modules.sys.security.utils.JwtTokenUtil;

/**
 * description: token过滤器，用来验证token的有效性
 * create: 2019-03-21 15:41
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    public JwtAuthenticationTokenFilter() {

    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        if (token != null && StringUtils.startsWith(token, JwtTokenUtil.TOKEN_PREFIX)) {
            token = StringUtils.substring(token, JwtTokenUtil.TOKEN_PREFIX.length());
        } else {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String username = JwtTokenUtil.getUsername(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                /*
                 *  注意：
                 *       这里代码不应该从数据库中去查，而是从缓存中根据token去查，目前只是做测试，无关紧要
                 *      如果是真正的项目实际开发需要增加缓存
                 */
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (JwtTokenUtil.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetails(request));


                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }
        } catch (Exception e) {
            response.setContentType("application/json;charset=UTF-8");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, BusRetEnum.BUS_PERMISSION_TOKEN_INVALID.getValue());
            //response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"token已失效")));
            return;
        }

        filterChain.doFilter(request, response);
    }
}
