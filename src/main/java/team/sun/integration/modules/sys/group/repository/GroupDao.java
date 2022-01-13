package team.sun.integration.modules.sys.group.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.group.model.entity.Group;

import java.util.Optional;

/**
 * <p>
 * 系统-用户组：	组具有自己的角色信息、权限信息 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-01
 */
@Repository
public interface GroupDao extends IDao<Group, String> {

    @Override
    @EntityGraph("Group-relation")
    Optional<Group> findById(String id);
}
