package team.sun.integration.modules.sys.position.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.position.model.entity.Position;

import java.util.Optional;

/**
 * <p>
 * 系统-职位
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
@Repository
public interface PositionDao extends IDao<Position, String> {

    @Override
    @EntityGraph("Position-relation")
    Optional<Position> findById(String id);
}
