package team.sun.integration.modules.tool_test.tool.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.tool_test.tool.model.dto.save.ToolClassifySaveDTO;
import team.sun.integration.modules.tool_test.tool.model.dto.update.ToolClassifyUpdateDTO;
import team.sun.integration.modules.tool_test.tool.model.entity.QToolClassify;
import team.sun.integration.modules.tool_test.tool.model.entity.ToolClassify;
import team.sun.integration.modules.tool_test.tool.repository.ToolClassifyDao;
import team.sun.integration.modules.tool_test.tool.service.ToolClassifyService;

import java.util.Optional;

/**
 * <p>
 * 工器具-分类
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Service
public class ToolClassifyServiceImpl extends ServiceImpl<ToolClassifyDao, ToolClassify> implements ToolClassifyService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QToolClassify qToolClassify = QToolClassify.toolClassify;
        BlazeJPAQuery<ToolClassify> blazeJPAQuery = new BlazeJPAQuery<ToolClassify>(entityManager, criteriaBuilderFactory)
                .from(qToolClassify)
                .select(qToolClassify)
                .where(predicate).orderBy(qToolClassify.id.asc().nullsLast());
        PagedList<ToolClassify> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public ToolClassify save(ToolClassifySaveDTO dto) {
        ToolClassify entity = new ToolClassify();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public ToolClassify update(ToolClassifyUpdateDTO dto) {
        Optional<ToolClassify> optional = this.getById(dto.getId());
        optional.ifPresent(ToolClassify -> {
            BeanUtils.copyProperties(dto, ToolClassify);
            this.dao.save(ToolClassify);
        });
        return optional.orElse(null);
    }
}
