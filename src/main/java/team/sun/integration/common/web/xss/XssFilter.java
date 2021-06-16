package team.sun.integration.common.web.xss;

import java.io.IOException;
import java.util.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.UrlPathHelper;

import static java.util.Objects.*;

/**
 * author TaoYu, MaYing
 */
public class XssFilter extends OncePerRequestFilter {

    private final PathMatcher pathMatcher = new AntPathMatcher();

    private final UrlPathHelper urlPathHelper = new UrlPathHelper();

    private List<String> whiteUrlPatterns = new LinkedList<>();

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, HttpServletResponse response,
                                    @NotNull FilterChain filterChain)
            throws ServletException, IOException {
        String lookupPath = urlPathHelper.getLookupPathForRequest(request);
        for (String whiteUrlPattern : whiteUrlPatterns) {
            if (pathMatcher.match(whiteUrlPattern, lookupPath)) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        filterChain.doFilter(new XssHttpServletRequestWrapper(request), response);
    }

    public void setWhiteUrlPatterns(List<String> whiteUrlPatterns) {
        this.whiteUrlPatterns = whiteUrlPatterns;
    }

    private static class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

        private XssHttpServletRequestWrapper(HttpServletRequest servletRequest) {
            super(servletRequest);
        }

        @Override
        public String getHeader(String name) {
            String header = super.getHeader(name);
            if (!StringUtils.isEmpty(header)) {
                header = HtmlUtils.htmlEscape(header);
            }
            return header;
        }

        @Override
        public String getQueryString() {
            String queryString = super.getQueryString();
            if (!StringUtils.isEmpty(queryString)) {
                queryString = HtmlUtils.htmlEscape(queryString);
            }
            return queryString;
        }

        @Override
        public String getParameter(String parameter) {
            String input = super.getParameter(parameter);
            if (!StringUtils.isEmpty(input)) {
                input = HtmlUtils.htmlEscape(input);
            }
            return input;
        }

        @Override
        public String[] getParameterValues(String parameter) {
            String[] values = super.getParameterValues(parameter);
            if (!(values == null || values.length == 0)) {
                for (int i = 0; i < values.length; i++) {
                    if (!StringUtils.isEmpty(values[i])) {
                        values[i] = HtmlUtils.htmlEscape(values[i]);
                    }
                }
            }
            return values;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            Map<String, String[]> paramMap = new HashMap<>(super.getParameterMap());
            for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                String[] values = entry.getValue();
                String[] after = new String[values.length];
                int index = 0;
                for (String value : values) {
                    if (!StringUtils.isEmpty(value)) {
                        after[index++] = HtmlUtils.htmlEscape(value);
                    } else {
                        after[index++] = value;
                    }
                }
                entry.setValue(after);
            }
            return paramMap;
        }
    }
}