package team.sun.integration.modules.sys.tenant.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.tenant.model.dto.save.TenantSaveDTO;
import team.sun.integration.modules.sys.tenant.model.dto.update.TenantUpdateDTO;
import team.sun.integration.modules.sys.tenant.model.entity.QTenant;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;
import team.sun.integration.modules.sys.tenant.model.vo.page.TenantPageVO;
import team.sun.integration.modules.sys.tenant.repository.TenantDao;
import team.sun.integration.modules.sys.tenant.service.TenantService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        QTenant qTenant = QTenant.tenant;
        BlazeJPAQuery<Tuple> blazeJPAQuery = new BlazeJPAQuery<Tuple>(entityManager, criteriaBuilderFactory)
                .from(qTenant)
                .select(qTenant, qTenant.applications.any().id.count().as("application_number"))
                .where(predicate).orderBy(qTenant.id.asc().nullsLast());
        PagedList<Tuple> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        List<TenantPageVO> pageVOS = new ArrayList<>();
        pages.forEach(entity->{
            TenantPageVO pageVO = new TenantPageVO();
            BeanUtils.copyProperties(Objects.requireNonNull(entity.get(0, Tenant.class)), pageVO);
            pageVO.setApplicationNumber(entity.get(1, Long.class));
            pageVOS.add(pageVO);
        });

        return new PageRet(pageVOS, pages.getTotalPages());
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
        optional.ifPresent(tenant -> {
            BeanUtils.copyProperties(dto, tenant);
            this.dao.save(tenant);
        });
        return optional.orElse(null);
    }

    @Override
    public TenantVO getTenantById(String id) {
        Optional<Tenant> optional = this.getById(id);
        TenantVO vo = new TenantVO();
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, vo));
        return vo;
    }
}
