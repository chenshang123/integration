package team.sun.integration.modules.sys.role.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import team.sun.integration.modules.sys.permission.model.entity.Permission;
import team.sun.integration.modules.sys.permission.repository.PermissionDao;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.role.repository.RoleDao;
import team.sun.integration.modules.sys.role.service.RoleService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * <p>
 * 系统-角色：	角色关联单位 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
    private final PermissionDao permissionDao;

    public RoleServiceImpl(RoleDao roleDao, PermissionDao permissionDao) {
        this.roleDao = roleDao;
        this.permissionDao = permissionDao;
    }

    @Override
    public void authZ(String roleId, List<String> permissionIds) {
        Optional<Role> role = roleDao.findById(roleId);
        role.ifPresent(o -> {
            //删除: 多对多关系-角色权限
            roleDao.deletePermissionMid(roleId);
            //添加: 多对多关系-角色权限
            Iterable<Permission> permissions = permissionDao.findAllById(permissionIds);
            o.setRolePermissions(Sets.newHashSet(permissions));
            roleDao.save(o);
        });
    }

    @Override
    public List<Role> getRoleList() {
        return Lists.newArrayList(roleDao.findAll());
    }

    @Override
    public List<String> findPermissionIds(List<String> roleIds) {
        List<String> permissionIds = new ArrayList<>();
        Iterable<Role> roles = roleDao.findAllById(roleIds);
        roles.forEach(role -> role.getRolePermissions().
                forEach(permission -> permissionIds.add(permission.getId())));
        return permissionIds;
    }
}
