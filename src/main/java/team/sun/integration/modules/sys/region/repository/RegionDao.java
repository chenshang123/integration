package team.sun.integration.modules.sys.region.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.sys.region.model.entity.Region;

import java.util.Optional;

/**
 * <p>
 * 系统-行政区域
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Repository
public interface RegionDao extends IDao<Region, String> {

    @Override
    @EntityGraph("Region-relation")
    Optional<Region> findById(String id);
}
