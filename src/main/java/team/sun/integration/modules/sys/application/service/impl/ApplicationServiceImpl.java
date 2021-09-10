package team.sun.integration.modules.sys.application.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
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
import team.sun.integration.modules.sys.application.repository.ApplicationDao;
import team.sun.integration.modules.sys.application.service.ApplicationService;

import java.util.Optional;

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
        BlazeJPAQuery<Application> blazeJPAQuery = new BlazeJPAQuery<Application>(entityManager, criteriaBuilderFactory)
                .from(qApplication)
                .select(qApplication)
                .where(predicate).orderBy(qApplication.id.asc().nullsLast());
        PagedList<Application> applications = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(applications, applications.getTotalSize());
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
        Optional<Application> optional = this.dao.findById(id);
        ApplicationVO vo = new ApplicationVO();
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, vo));
        return vo;
    }
}
