package team.sun.integration.modules.sys.tenant.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;

import java.util.Optional;

/**
 * <p>
 * 系统-租户
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
@Repository
public interface TenantDao extends IDao<Tenant, String> {

    @Override
    @EntityGraph("Tenant-relation")
    Optional<Tenant> findById(String id);
}
