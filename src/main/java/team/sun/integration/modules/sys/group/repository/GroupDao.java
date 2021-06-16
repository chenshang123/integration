package team.sun.integration.modules.sys.group.repository;

import org.springframework.data.jpa.repository.Query;
import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.sys.group.model.entity.Group;

/**
 * <p>
 * 系统-用户组：	组具有自己的角色信息、权限信息 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-01
 */

public interface GroupDao extends IDao<Group, String> {

    @Query(value = "delete from sys_group_data_node_mid where group_id = ?1", nativeQuery = true)
    void deleteDataNodeMid(String groupId);

    @Query(value = "delete from sys_group_role_mid where group_id = ?1", nativeQuery = true)
    void deleteRoleMid(String groupId);

    @Query(value = "delete from sys_group_user_mid where group_id = ?1", nativeQuery = true)
    void deleteUserMid(String groupId);

}
