package team.sun.integration.common.web.jwt;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.UrlPathHelper;
import team.sun.integration.common.utils.JwtUtils;


/**
 * 默认环境下的jwt过滤器
 *
 * @author TaoYu
 */
public class JwtFilter extends OncePerRequestFilter {

    private final PathMatcher pathMatcher = new AntPathMatcher();

    private final UrlPathHelper urlPathHelper = new UrlPathHelper();

    private JwtProcessor jwtProcessor;

    private List<String> whiteUrlPatterns;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String lookupPath = urlPathHelper.getLookupPathForRequest(request);
        if (!CollectionUtils.isEmpty(whiteUrlPatterns)) {
            for (String whiteUrlPattern : whiteUrlPatterns) {
                if (pathMatcher.match(whiteUrlPattern, lookupPath)) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }
        }
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (jwtToken == null || ((JwtUtils.parseToken(jwtToken)) == null)) {
            jwtProcessor.process(request, response);
            return;
        }
        filterChain.doFilter(request, response);
    }

    public void setJwtProcessor(JwtProcessor jwtProcessor) {
        this.jwtProcessor = jwtProcessor;
    }

    public void setWhiteUrlPatterns(List<String> whiteUrlPatterns) {
        this.whiteUrlPatterns = whiteUrlPatterns;
    }
}
