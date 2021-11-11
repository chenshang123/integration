package team.sun.integration.modules.sys.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;
import team.sun.integration.modules.sys.security.utils.JwtSecurityUtil;
import team.sun.integration.modules.sys.user.model.vo.login.UserLoginVO;
import team.sun.integration.modules.sys.user.service.UserService;

import java.util.Optional;

@Configuration
public class UserIDAuditorConfig implements AuditorAware<String> {

    /**
     * 查询当前用户id
     */
    @Override
    public @NotNull Optional<String> getCurrentAuditor() {
        return JwtSecurityUtil.getCurrentUserID();
    }

}
