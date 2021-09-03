package team.sun.integration.modules.sys.tenant.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.tenant.model.entity.TenantApplication;

import java.util.Optional;

/**
 * <p>
 * 系统-租户与应用关系
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
@Repository
public interface TenantApplicationDao extends IDao<TenantApplication, String> {

    @EntityGraph("-relation")
    Optional<TenantApplication> findTenantApplicationById(String id);
}
