package team.sun.integration.modules.sys.application.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.sys.application.model.entity.Application;

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
public interface ApplicationVersionDao extends IDao<Application, String> {

    @EntityGraph("ApplicationVersion-relation")
    Optional<Application> findApplicationVersionById(String id);

}
