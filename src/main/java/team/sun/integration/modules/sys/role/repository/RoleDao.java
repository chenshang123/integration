package team.sun.integration.modules.sys.role.repository;

import org.springframework.data.jpa.repository.Query;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.sys.role.model.entity.Role;

/**
 * <p>
 * 系统-角色：	角色关联单位 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface RoleDao extends IDao<Role, String> {

    @Query(value = "delete from sys_role_permission_mid where role_id = ?1", nativeQuery = true)
    void deletePermissionMid(String userId);
}
