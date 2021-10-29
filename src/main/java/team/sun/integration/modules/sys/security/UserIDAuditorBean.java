package team.sun.integration.modules.sys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;
import team.sun.integration.modules.sys.security.utils.JwtSecurityUtil;
import team.sun.integration.modules.sys.user.model.vo.login.UserLoginVO;
import team.sun.integration.modules.sys.user.service.UserService;

import java.util.Optional;

@Configuration
public class UserIDAuditorBean implements AuditorAware<String> {

    private final UserService userService;

    @Autowired
    public UserIDAuditorBean(UserService userService) {
        this.userService = userService;
    }

    /**
     * TODO：可以继续优化,可以在redis中实现
     * 查询当前用户id
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        String userName = JwtSecurityUtil.getCurrentUserName();
        UserLoginVO userLoginVO = null;
        if(StringUtils.hasLength(userName)) {
            userLoginVO = userService.getByUsername(userName, false);
        }
        return Optional.ofNullable(userLoginVO).map(vo -> vo.getUsername());
    }

}
