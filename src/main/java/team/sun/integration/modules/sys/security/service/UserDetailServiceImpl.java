package team.sun.integration.modules.sys.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.sun.integration.modules.sys.user.model.vo.UserRoleVO;
import team.sun.integration.modules.sys.user.service.UserService;

/**
 * <p>
 * security 自定义登陆逻辑类
 * 用来做登陆认证，验证用户名与密码
 * </p>
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRoleVO vo = userService.getByUsername(username, true);
        // 根据用户名去查找用户信息
        if (vo == null) {
            throw new UsernameNotFoundException(String.format("Not user Found with '%s'", username));
        }
        return new User(vo.getUser().getUsername(), vo.getUser().getPwd(), getGrantedAuthority(vo.getRoleIds()));
    }

    /***
     * Description: 获取角色权限
     * Param: [roleIds]
     * return: java.util.List<org.springframework.security.core.GrantedAuthority>
     * Author: wangzh
     * Date: 2019/3/21
     */
    private List<GrantedAuthority> getGrantedAuthority(List<String> roleIds) {
        List<GrantedAuthority> authorities = new ArrayList<>(roleIds.size());

        for (String role : roleIds) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
