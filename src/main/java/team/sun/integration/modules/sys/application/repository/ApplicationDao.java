package team.sun.integration.modules.sys.application.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.application.model.entity.Application;

import java.util.Optional;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Repository
public interface ApplicationDao extends IDao<Application, String> {

    @Override
    @EntityGraph("Application-relation")
    @NotNull
    Optional<Application> findById(@NotNull String id);

}
