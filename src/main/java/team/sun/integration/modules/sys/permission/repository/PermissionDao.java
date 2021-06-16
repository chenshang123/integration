package team.sun.integration.modules.sys.permission.repository;

import org.springframework.data.jpa.repository.Query;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.sys.permission.model.entity.Permission;

/**
 * <p>
 * 系统-权限表 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface PermissionDao extends IDao<Permission, String> {

    @Query(value = "delete from sys_permission_resource_mid where permission_id = ?1", nativeQuery = true)
    void deleteResourceMid(String permissionId);
}
