package team.sun.integration.modules.sys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import team.sun.integration.modules.sys.security.filter.JwtAuthenticationTokenFilter;
import team.sun.integration.modules.sys.security.handler.JwtAuthenticationEntryPoint;
import team.sun.integration.modules.sys.security.handler.LoginFailHandler;
import team.sun.integration.modules.sys.security.handler.LoginSuccessHandler;
import team.sun.integration.modules.sys.security.handler.RestAuthenticationAccessDeniedHandler;

/**
 * ClassName:WebSecurityConfig <br/>
 * Function: security 配置类 <br/>
 * Date: 2018年9月17日 上午10:23:44 <br/>
 *
 * @since JDK 1.8
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    @Autowired
    private RestAuthenticationAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Bean
    public PasswordEncoder getPasswordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LoginSuccessHandler getLoginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LoginFailHandler getLoginFailHandler() {
        return new LoginFailHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/authentication/login")
                .loginProcessingUrl("/authentication/form")
                .successHandler(getLoginSuccessHandler())
                .failureHandler(getLoginFailHandler())
                .and()
                //自定义权限拒绝处理类
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .csrf().disable() //使用jwt，不需要csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //基于token，不需要session
                .and()
                .authorizeRequests() // 路径鉴权
                // 设置允许访问的资源
                .antMatchers("/authentication/login").permitAll()
                // 设置允许访问的资源
                .antMatchers("/webjars/**").permitAll()
                .antMatchers(
                        //文件上传
                        "/sys/file/upload",
                        // swagger
                        "/swagger-ui/index.html",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/webjars/**",
                        // swagger api json
                        "/v3/api-docs",
                        //用来获取支持的动作
                        "/swagger-resources/configuration/ui",
                        //用来获取api-docs的URI
                        "/swagger-resources",
                        //安全选项
                        "/swagger-resources/configuration/security",
                        "/swagger-resources/**"

                ).permitAll()
                .anyRequest().authenticated();

        // 禁用缓存
        http.headers().cacheControl();

        // 添加JWT filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
