package team.sun.integration.modules.sys.security.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import team.sun.integration.common.base.enums.ret.BusRetEnum;
import team.sun.integration.common.base.model.vo.Ret;

/**
 * <p>
 * 登陆失败处理器
 * </p>
 */
public class LoginFailHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {

        response.setContentType("application/json;charset=UTF-8");
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, BusRetEnum.BUS_LOGIN_BAD_CREDENTIALS.getValue());
        response.getWriter().write(objectMapper.writeValueAsString(Ret.fail(BusRetEnum.BUS_LOGIN_BAD_CREDENTIALS)));
//        response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"登陆失败：" + exception.getMessage())));
    }
}
