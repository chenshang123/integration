package team.sun.integration.common.web.jwt;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface JwtProcessor {

    void process(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
