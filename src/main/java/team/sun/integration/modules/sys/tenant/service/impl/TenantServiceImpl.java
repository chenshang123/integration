package team.sun.integration.modules.sys.tenant.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.tenant.model.dto.save.TenantSaveDTO;
import team.sun.integration.modules.sys.tenant.model.dto.update.TenantUpdateDTO;
import team.sun.integration.modules.sys.tenant.model.entity.QTenant;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.tenant.repository.TenantDao;
import team.sun.integration.modules.sys.tenant.service.TenantService;

import java.util.Optional;

/**
 * <p>
 * 系统-租户
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantDao, Tenant> implements TenantService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QTenant qTenant = QTenant.tenant1;
        BlazeJPAQuery<Tenant> blazeJPAQuery = new BlazeJPAQuery<Tenant>(entityManager, criteriaBuilderFactory)
                .from(qTenant)
                .select(qTenant)
                .where(predicate).orderBy(qTenant.id.asc().nullsLast());
        PagedList<Tenant> Tenants = blazeJPAQuery.fetchPage((int)pageable.getOffset(), pageable.getPageSize());

        return new PageRet(Tenants, Tenants.getTotalSize());
    }

    @Override
    public Tenant save(TenantSaveDTO dto) {
        Tenant entity = new Tenant();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Tenant update(TenantUpdateDTO dto) {
        Optional<Tenant> optional = this.getById(dto.getId());
        optional.ifPresent(Tenant -> {
            BeanUtils.copyProperties(dto, Tenant);
            this.dao.save(Tenant);
        });
        return optional.orElse(null);
    }
}
