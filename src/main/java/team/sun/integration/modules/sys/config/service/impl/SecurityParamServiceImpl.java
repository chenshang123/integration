package team.sun.integration.modules.sys.config.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.config.model.dto.save.SecurityParamSaveDTO;
import team.sun.integration.modules.sys.config.model.dto.update.SecurityParamUpdateDTO;
import team.sun.integration.modules.sys.config.model.entity.QSecurityParam;
import team.sun.integration.modules.sys.config.model.entity.SecurityParam;
import team.sun.integration.modules.sys.config.repository.SecurityParamDao;
import team.sun.integration.modules.sys.config.service.SecurityParamService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * 系统-参数配置 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-24
 */
@Service
public class SecurityParamServiceImpl extends ServiceImpl<SecurityParamDao, SecurityParam> implements SecurityParamService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QSecurityParam qSecurityParam = QSecurityParam.securityParam;
        BlazeJPAQuery<SecurityParam> blazeJPAQuery = new BlazeJPAQuery<SecurityParam>(entityManager, criteriaBuilderFactory)
                .from(qSecurityParam)
                .select(qSecurityParam)
                .where(predicate).orderBy(qSecurityParam.id.asc().nullsLast());
        PagedList<SecurityParam> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public SecurityParam save(SecurityParamSaveDTO dto) {
        SecurityParam entity = new SecurityParam();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public SecurityParam update(SecurityParamUpdateDTO dto) {
        Optional<SecurityParam> optional = this.getById(dto.getId());
        optional.ifPresent(SecurityParam -> {
            BeanUtils.copyProperties(dto, SecurityParam);
            this.dao.save(SecurityParam);
        });
        return optional.orElse(null);
    }
}
