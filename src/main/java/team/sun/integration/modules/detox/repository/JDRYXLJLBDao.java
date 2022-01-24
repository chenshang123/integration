package team.sun.integration.modules.detox.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.detox.model.entity.JDRYTZCSJLB;
import team.sun.integration.modules.detox.model.entity.JDRYXLJLB;

import java.util.Optional;

/**
 * <p>
 * 戒毒人员训练记录
 * </p>
 *
 * @author auto generator
 * @since 2022-01-14
 */
@Repository
public interface JDRYXLJLBDao extends IDao<JDRYXLJLB, String> {

    @Override
//    @EntityGraph("JDRYTZCSJLB-relation")
    @NotNull
    Optional<JDRYXLJLB> findById(@NotNull String id);

}
