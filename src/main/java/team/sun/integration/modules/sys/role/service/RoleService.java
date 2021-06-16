package team.sun.integration.modules.sys.role.service;

import team.sun.integration.modules.sys.role.model.entity.Role;

import java.util.List;

/**
 * <p>
 * 系统-角色：	角色关联单位 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface RoleService {

    /**
     * 给角色授权权限
     *
     * @param roleId        角色id
     * @param permissionIds 权限ids
     */
    void authZ(String roleId, List<String> permissionIds);

    /**
     * 获取可选的角色列表
     *
     * @return 角色集合
     */
    List<Role> getRoleList();

    /**
     * 查询角色对应的资源操作权限
     *
     * @param roleIds 角色ids
     * @return 权限ids
     */
    public List<String> findPermissionIds(List<String> roleIds);

}
