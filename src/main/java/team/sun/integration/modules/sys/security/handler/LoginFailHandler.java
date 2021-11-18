package team.sun.integration.modules.sys.security.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import team.sun.integration.modules.base.enums.ret.BusRetEnum;

/**
 * <p>
 * 登陆失败处理器
 * </p>
 */
public class LoginFailHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {

        response.setContentType("application/json;charset=UTF-8");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, BusRetEnum.BUS_LOGIN_BAD_CREDENTIALS.getValue());
//        response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"登陆失败：" + exception.getMessage())));
    }
}
