package team.sun.integration.modules.sys.security.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import team.sun.integration.modules.base.enums.ret.BusRetEnum;
import team.sun.integration.modules.base.model.vo.Ret;
import team.sun.integration.modules.sys.security.utils.JwtTokenUtil;

/**
 * <p>
 * 登陆成功处理器
 * 1.create token
 * </p>
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            User details = (User) userDetailsService.loadUserByUsername(authentication.getName());

            String token = JwtTokenUtil.TOKEN_PREFIX + JwtTokenUtil.createToken(details, false);

            response.setHeader(JwtTokenUtil.TOKEN_HEADER, token);
//            response.sendRedirect(token);
            response.getWriter().write(objectMapper.writeValueAsString(Ret.success(token)));
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, BusRetEnum.BUS_LOGIN_CREATE_TOKEN_FAIL.getValue());
//            response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"创建token失败，请与管理员联系")));
        }

    }

}
