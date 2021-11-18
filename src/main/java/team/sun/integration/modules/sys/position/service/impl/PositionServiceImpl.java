package team.sun.integration.modules.sys.position.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.position.model.dto.save.PositionSaveDTO;
import team.sun.integration.modules.sys.position.model.dto.update.PositionUpdateDTO;
import team.sun.integration.modules.sys.position.model.entity.Position;
import team.sun.integration.modules.sys.position.model.entity.QPosition;
import team.sun.integration.modules.sys.position.model.vo.PositionVO;
import team.sun.integration.modules.sys.position.repository.PositionDao;
import team.sun.integration.modules.sys.position.service.PositionService;

import java.util.Optional;

/**
 * <p>
 * 系统-职位
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionDao, Position> implements PositionService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QPosition qPosition = QPosition.position;
        BlazeJPAQuery<Position> blazeJPAQuery = new BlazeJPAQuery<Position>(entityManager, criteriaBuilderFactory)
                .from(qPosition)
                .select(qPosition)
                .where(predicate).orderBy(qPosition.id.asc().nullsLast());
        PagedList<Position> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public Position save(PositionSaveDTO dto) {
        Position entity = new Position();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Position update(PositionUpdateDTO dto) {
        Optional<Position> optional = this.getById(dto.getId());
        optional.ifPresent(position -> {
            BeanUtils.copyProperties(dto, position);
            this.dao.save(position);
        });
        return optional.orElse(null);
    }

    @Override
    public PositionVO getPositionById(String id) {
        Optional<Position> optional = this.dao.findById(id);
        PositionVO vo = new PositionVO();
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, vo));
        return vo;
    }
}
