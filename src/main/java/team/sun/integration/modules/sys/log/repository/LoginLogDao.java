package team.sun.integration.modules.sys.log.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.log.model.entity.LoginLog;

import java.util.Optional;

/**
 * <p>
 * 系统-登录日志
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Repository
public interface LoginLogDao extends IDao<LoginLog, String> {

    @Override
    @EntityGraph("LoginLog-relation")
    Optional<LoginLog> findById(String id);
}
