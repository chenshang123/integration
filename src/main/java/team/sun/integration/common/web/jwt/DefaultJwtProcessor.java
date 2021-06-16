package team.sun.integration.common.web.jwt;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultJwtProcessor implements JwtProcessor {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "jwt认证失败");
    }

}
