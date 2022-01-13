package team.sun.integration.modules.sys.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import team.sun.integration.common.base.enums.ret.BusRetEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 验证为未登陆状态会进入此方法，认证错误
 * createAt: 2018/9/20
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        //验证为未登陆状态会进入此方法，认证错误
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, BusRetEnum.BUS_LOGIN_NOT_LOGGED_IN.getValue());
    }
}
