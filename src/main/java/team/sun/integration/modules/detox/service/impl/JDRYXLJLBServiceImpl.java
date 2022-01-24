package team.sun.integration.modules.detox.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.detox.model.dto.save.JDRYXLJLBSaveDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYXLJLBUpdateDTO;
import team.sun.integration.modules.detox.model.entity.JDRYXLJLB;
import team.sun.integration.modules.detox.model.entity.QJDRYXLJLB;
import team.sun.integration.modules.detox.model.vo.JDRYXLJLBVO;
import team.sun.integration.modules.detox.model.vo.page.JDRYXLJLBPageVO;
import team.sun.integration.modules.detox.repository.JDRYXLJLBDao;
import team.sun.integration.modules.detox.service.JDRYXLJLBService;
import team.sun.integration.modules.sys.resource.model.vo.ResourceVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 戒毒-人员训练记录
 * </p>
 *
 * @author auto generator
 * @since 2022-01-14
 */
@Service
public class JDRYXLJLBServiceImpl extends ServiceImpl<JDRYXLJLBDao, JDRYXLJLB> implements JDRYXLJLBService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QJDRYXLJLB qJDRYXLJLB = QJDRYXLJLB.jDRYXLJLB;
        BlazeJPAQuery<JDRYXLJLB> blazeJPAQuery = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory)
                .from(qJDRYXLJLB)
                .select(qJDRYXLJLB)
                .where(predicate).orderBy(qJDRYXLJLB.BH.asc().nullsLast());
        PagedList<JDRYXLJLB> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        List<JDRYXLJLBPageVO> pageVOS = new ArrayList<>();
        pages.forEach(entity -> {
            JDRYXLJLBPageVO pageVO = new JDRYXLJLBPageVO();
            BeanUtils.copyProperties(entity, pageVO);
            pageVOS.add(pageVO);
        });

        return new PageRet(pageVOS, pages.getTotalSize());
    }

    @Override
    public JDRYXLJLB save(JDRYXLJLBSaveDTO dto) {
        JDRYXLJLB entity = new JDRYXLJLB();
        BeanUtils.copyProperties(dto, entity);
        return this.saveOrUpdate(entity);
    }

    @Override
    public JDRYXLJLB update(JDRYXLJLBUpdateDTO dto) {
        Optional<JDRYXLJLB> optional = this.getById(dto.getBH());
        optional.ifPresent(JDRYXLJLB -> {
            BeanUtils.copyProperties(dto, JDRYXLJLB);
            this.saveOrUpdate(JDRYXLJLB);
        });
        return optional.orElse(null);
    }

    @Override
    public JDRYXLJLBVO getVOById(String id) {
        Optional<JDRYXLJLB> optional = this.getById(id);
        JDRYXLJLBVO JDRYXLJLBVO = new JDRYXLJLBVO();
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, JDRYXLJLBVO));
        return JDRYXLJLBVO;
    }
}
