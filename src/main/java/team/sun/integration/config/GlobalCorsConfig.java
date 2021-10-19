package team.sun.integration.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsConfig() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
        // 是否发送 Cookie
        corsConfiguration.setAllowCredentials(true);
        // 允许跨域访问的源
        corsConfiguration.addAllowedOriginPattern(org.springframework.web.cors.CorsConfiguration.ALL);
        // 允许头部设置
        corsConfiguration.addAllowedHeader(org.springframework.web.cors.CorsConfiguration.ALL);
        // 允许请求方法
        corsConfiguration.addAllowedMethod(org.springframework.web.cors.CorsConfiguration.ALL);
        // 预检间隔时间，单位：秒
        corsConfiguration.setMaxAge(1800L);
        // 允许跨域访问的路径
        source.registerCorsConfiguration("/**", corsConfiguration);
        // 注入 Filter
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new CorsFilter(source));
        bean.setName("corsFilter");
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
