package team.sun.integration.modules.sys.resource.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.sys.resource.model.entity.Resource;

import java.util.Optional;

/**
 * <p>
 * 系统-菜单： Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Repository
public interface ResourceDao extends IDao<Resource, String> {

    @Override
    @EntityGraph("Resource-relation")
    Optional<Resource> findById(String id);
}
