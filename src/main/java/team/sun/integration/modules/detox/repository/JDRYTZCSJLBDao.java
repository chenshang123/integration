package team.sun.integration.modules.detox.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.detox.model.entity.JDRYTZCSJLB;
import team.sun.integration.modules.sys.application.model.entity.Application;

import java.util.Optional;

/**
 * <p>
 * 戒毒人员体质测试
 * </p>
 *
 * @author auto generator
 * @since 2022-01-14
 */
@Repository
public interface JDRYTZCSJLBDao extends IDao<JDRYTZCSJLB, String> {

    @Override
//    @EntityGraph("JDRYTZCSJLB-relation")
    @NotNull
    Optional<JDRYTZCSJLB> findById(@NotNull String id);

}
