package team.sun.integration.modules.sys.region.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.region.model.dto.save.RegionSaveDTO;
import team.sun.integration.modules.sys.region.model.dto.update.RegionUpdateDTO;
import team.sun.integration.modules.sys.region.model.entity.QRegion;
import team.sun.integration.modules.sys.region.model.entity.Region;
import team.sun.integration.modules.sys.region.repository.RegionDao;
import team.sun.integration.modules.sys.region.service.RegionService;

import java.util.Optional;

/**
 * <p>
 * 系统-行政区域
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionDao, Region> implements RegionService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QRegion qRegion = QRegion.region;
        BlazeJPAQuery<Region> blazeJPAQuery = new BlazeJPAQuery<Region>(entityManager, criteriaBuilderFactory)
                .from(qRegion)
                .select(qRegion)
                .where(predicate).orderBy(qRegion.id.asc().nullsLast());
        PagedList<Region> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public Region save(RegionSaveDTO dto) {
        Region entity = new Region();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Region update(RegionUpdateDTO dto) {
        Optional<Region> optional = this.getById(dto.getId());
        optional.ifPresent(Region -> {
            BeanUtils.copyProperties(dto, Region);
            this.dao.save(Region);
        });
        return optional.orElse(null);
    }
}
