package team.sun.integration.modules.detox.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.detox.model.entity.JDRYXLJLB;
import team.sun.integration.modules.detox.model.entity.JDRYXLKHPGB;

import java.util.Optional;

/**
 * <p>
 * 戒毒人员员训练考核评估
 * </p>
 *
 * @author auto generator
 * @since 2022-01-14
 */
@Repository
public interface JDRYXLKHPGBDao extends IDao<JDRYXLKHPGB, String> {

    @Override
//    @EntityGraph("JDRYTZCSJLB-relation")
    @NotNull
    Optional<JDRYXLKHPGB> findById(@NotNull String id);

}
