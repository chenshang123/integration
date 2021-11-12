package team.sun.integration.modules.sys.tenant.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.tenant.model.dto.save.TenantSaveDTO;
import team.sun.integration.modules.sys.tenant.model.dto.update.TenantUpdateDTO;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.tenant.model.vo.TenantApplicationVO;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;

import java.util.List;

/**
 * <p>
 * 系统-租户
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
public interface TenantService extends IService<Tenant, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    Tenant save(TenantSaveDTO entity);

    Tenant update(TenantUpdateDTO entity);

    TenantVO getTenantById(String id);
}
