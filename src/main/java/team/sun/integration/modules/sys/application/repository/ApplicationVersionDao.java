package team.sun.integration.modules.sys.application.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.application.model.entity.ApplicationVersion;

import java.util.Optional;

/**
 * <p>
 * 系统-应用版本
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Repository
public interface ApplicationVersionDao extends IDao<ApplicationVersion, String> {

    @Override
    @EntityGraph("ApplicationVersion-relation")
    @NotNull
    Optional<ApplicationVersion> findById(@NotNull String id);

}
