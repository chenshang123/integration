package team.sun.integration.modules.sys.permission.service;

import team.sun.integration.modules.sys.permission.model.entity.Permission;

import java.util.List;

/**
 * <p>
 * 系统-权限表 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface PermissionService {

    /**
     * 获取资源
     *
     * @param permissionIds 权限ids
     * @return
     */
    public List<String> findResourceIds(List<String> permissionIds);

    /**
     * 权限管理资源
     *
     * @param permissionId 权限id
     * @param resourceIds  菜单ids
     */
    void authZResource(String permissionId, List<String> resourceIds);

    /**
     * 获取可选的权限列表
     *
     * @return
     */
    List<Permission> getPermissionList();

    void clearPermissionCache();
}
