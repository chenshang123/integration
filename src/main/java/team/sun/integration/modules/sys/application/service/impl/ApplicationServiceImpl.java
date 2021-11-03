package team.sun.integration.modules.sys.application.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.application.model.dto.save.ApplicationSaveDTO;
import team.sun.integration.modules.sys.application.model.dto.update.ApplicationUpdateDTO;
import team.sun.integration.modules.sys.application.model.entity.Application;
import team.sun.integration.modules.sys.application.model.entity.QApplication;
import team.sun.integration.modules.sys.application.model.vo.ApplicationVO;
import team.sun.integration.modules.sys.application.model.vo.page.ApplicationPageVO;
import team.sun.integration.modules.sys.application.repository.ApplicationDao;
import team.sun.integration.modules.sys.application.service.ApplicationService;
import team.sun.integration.modules.sys.resource.model.vo.ResourceVO;
import team.sun.integration.modules.sys.tenant.model.entity.QTenantApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationDao, Application> implements ApplicationService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QApplication qApplication = QApplication.application;
        QTenantApplication qTenantApplication = QTenantApplication.tenantApplication;
        BlazeJPAQuery<Tuple> blazeJPAQuery = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory)
                .from(qApplication)
                .select(qApplication, qTenantApplication.id.count().as("tenant_number"))
                .innerJoin(qApplication.tenantApplications, qTenantApplication)
                .groupBy(qTenantApplication.id)
                .where(predicate).orderBy(qApplication.id.asc().nullsLast());
        PagedList<Tuple> applications = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());
        List<ApplicationPageVO> pageVOS = new ArrayList<>();
        /*applications.forEach(entity->{
            ApplicationPageVO pageVO = new ApplicationPageVO();
            BeanUtils.copyProperties(Objects.requireNonNull(entity.get(0, Application.class)), pageVO);
            pageVO.setTenantNumber(entity.get(1, Long.class));
            pageVOS.add(pageVO);
                });*/
       /* pageVOS = Optional.of(applications).stream().filter(Objects::nonNull).map(entity ->
                entity.get(0);
                ).collect(Collectors.toList());*/
        return new PageRet(pageVOS, applications.getTotalSize());
    }

    @Override
    public Application save(ApplicationSaveDTO dto) {
        Application entity = new Application();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Application update(ApplicationUpdateDTO dto) {
        Optional<Application> optional = this.getById(dto.getId());
        optional.ifPresent(application -> {
            BeanUtils.copyProperties(dto, application);
            this.dao.save(application);
        });
        return optional.orElse(null);
    }

    @Override
    public ApplicationVO getApplicationById(String id) {
        Optional<Application> optional = this.dao.findApplicationById(id);
        ApplicationVO applicationVO = new ApplicationVO();
        optional.ifPresent(entity -> {
            BeanUtils.copyProperties(entity, applicationVO);
            entity.getResources().stream().filter(Objects::nonNull).forEach(resource -> {
                ResourceVO resourceVO = new ResourceVO();
                BeanUtils.copyProperties(resource, resourceVO);
                applicationVO.getResources().add(resourceVO);
            });
        });
        return applicationVO;
    }
}
