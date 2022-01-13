package team.sun.integration.modules.sys.role.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.role.model.entity.Role;

import java.util.Optional;

/**
 * <p>
 * 系统-角色：	角色关联单位 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Repository
public interface RoleDao extends IDao<Role, String> {

    @Override
    @EntityGraph("Role-relation")
    Optional<Role> findById(String id);
}
