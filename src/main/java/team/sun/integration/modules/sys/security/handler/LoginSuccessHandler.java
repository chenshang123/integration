package team.sun.integration.modules.sys.security.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import team.sun.integration.common.base.enums.ret.BusRetEnum;
import team.sun.integration.common.base.model.vo.Ret;
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
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            User details = (User) userDetailsService.loadUserByUsername(authentication.getName());
            String token = JwtTokenUtil.TOKEN_PREFIX + JwtTokenUtil.createToken(details, false);
            response.setHeader(JwtTokenUtil.TOKEN_HEADER, token);

            response.getWriter().write(objectMapper.writeValueAsString(Ret.success(token)));
        } catch (Exception e) {
            response.getWriter().write(objectMapper.writeValueAsString(Ret.fail(BusRetEnum.BUS_LOGIN_CREATE_TOKEN_FAIL)));
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, BusRetEnum.BUS_LOGIN_CREATE_TOKEN_FAIL.getValue());
//            response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"创建token失败，请与管理员联系")));
        }

    }

}
