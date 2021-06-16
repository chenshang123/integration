package team.sun.integration.modules.sys.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import team.sun.integration.modules.base.model.vo.Ret;
import team.sun.integration.modules.sys.security.utils.JwtTokenUtil;


@Api(tags = "系统-登陆验证相关接口")
@RestController
@RequestMapping("/authentication")
public class LoginController {


    private final UserDetailsService userDetailsService;

    @Autowired
    public LoginController(@Qualifier("userDetailServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/form")
    @ApiOperation(value = "登入身份验证（JWT验证）", notes = "登入")
    public void login(String username, String password) {
        // TODO 这里面不需要写任何代码，由UserDeatilsService去处理
    }

    @GetMapping("/getUserDetailByToken")
    @ApiOperation(value = "根据token得到用户信息")
    public Ret<UserDetails> getUserDetailByToken(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        response.setContentType("application/json;charset=UTF-8");
        if (token != null && StringUtils.startsWith(token, JwtTokenUtil.TOKEN_PREFIX)) {
            token = StringUtils.substring(token, JwtTokenUtil.TOKEN_PREFIX.length());
            UserDetails details = userDetailsService.loadUserByUsername(JwtTokenUtil.getUsername(token));
            return Ret.success(details);
        } else {
            return Ret.fail();
        }
    }

}
