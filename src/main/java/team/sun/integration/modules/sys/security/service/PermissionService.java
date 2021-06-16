package team.sun.integration.modules.sys.security.service;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import team.sun.integration.common.web.log.LogAspect;
import team.sun.integration.modules.sys.role.service.RoleService;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 接口权限判断工具
 */
@Component("pms")
public class PermissionService {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    private final RoleService roleService;

    @Autowired
    public PermissionService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 判断接口是否有xxx:xxx权限
     *
     * @param permission 权限
     * @return {boolean}
     */
    public boolean hasPermission(String permission) {
        if (StrUtil.isBlank(permission)) {
            return false;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roleIds = authorities.stream()
                .filter(Objects::nonNull)
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        //TODO 此处需要加缓存
        List<String> permissions = roleService.findPermissionIds(roleIds);
        return permissions.contains(permission);
    }
}
