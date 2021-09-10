package team.sun.integration.modules.sys.org.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.org.model.dto.save.OrgSaveDTO;
import team.sun.integration.modules.sys.org.model.dto.update.OrgUpdateDTO;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.org.model.entity.QOrg;
import team.sun.integration.modules.sys.org.model.vo.OrgVO;
import team.sun.integration.modules.sys.org.repository.OrgDao;
import team.sun.integration.modules.sys.org.service.OrgService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * 系统-单位/组织/机构 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgDao, Org> implements OrgService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QOrg qOrg = QOrg.org;
        BlazeJPAQuery<Org> blazeJPAQuery = new BlazeJPAQuery<Org>(entityManager, criteriaBuilderFactory)
                .from(qOrg)
                .select(qOrg)
                .where(predicate).orderBy(qOrg.id.asc().nullsLast());
        PagedList<Org> org = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(org, org.getTotalSize());
    }

    @Override
    public Org save(OrgSaveDTO dto) {
        Org entity = new Org();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Org update(OrgUpdateDTO dto) {
        Optional<Org> optional = this.getById(dto.getId());
        optional.ifPresent(Org -> {
            BeanUtils.copyProperties(dto, Org);
            this.dao.save(Org);
        });
        return optional.orElse(null);
    }

    @Override
    public OrgVO getOrgById(String id) {
        Optional<Org> optional = this.dao.findById(id);
        OrgVO vo = new OrgVO();
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, vo));
        return vo;
    }
}
