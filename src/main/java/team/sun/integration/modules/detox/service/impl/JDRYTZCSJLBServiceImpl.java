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
import team.sun.integration.modules.detox.model.dto.save.JDRYTZCSJLBSaveDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYTZCSJLBUpdateDTO;
import team.sun.integration.modules.detox.model.entity.JDRYTZCSJLB;
import team.sun.integration.modules.detox.model.entity.QJDRYTZCSJLB;
import team.sun.integration.modules.detox.model.vo.JDRYTZCSJLBVO;
import team.sun.integration.modules.detox.model.vo.page.JDRYTZCSJLBPageVO;
import team.sun.integration.modules.detox.repository.JDRYTZCSJLBDao;
import team.sun.integration.modules.detox.service.JDRYTZCSJLBService;
import team.sun.integration.modules.sys.resource.model.vo.ResourceVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 戒毒-人员体质测试
 * </p>
 *
 * @author auto generator
 * @since 2022-01-14
 */
@Service
public class JDRYTZCSJLBServiceImpl extends ServiceImpl<JDRYTZCSJLBDao, JDRYTZCSJLB> implements JDRYTZCSJLBService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QJDRYTZCSJLB qJDRYTZCSJLB = QJDRYTZCSJLB.jDRYTZCSJLB;
        BlazeJPAQuery<JDRYTZCSJLB> blazeJPAQuery = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory)
                .from(qJDRYTZCSJLB)
                .select(qJDRYTZCSJLB)
                .where(predicate).orderBy(qJDRYTZCSJLB.BH.asc().nullsLast());
        PagedList<JDRYTZCSJLB> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        List<JDRYTZCSJLBPageVO> pageVOS = new ArrayList<>();
        pages.forEach(entity -> {
            JDRYTZCSJLBPageVO pageVO = new JDRYTZCSJLBPageVO();
            BeanUtils.copyProperties(entity, pageVO);
            pageVOS.add(pageVO);
        });

        return new PageRet(pageVOS, pages.getTotalSize());
    }

    @Override
    public JDRYTZCSJLB save(JDRYTZCSJLBSaveDTO dto) {
        JDRYTZCSJLB entity = new JDRYTZCSJLB();
        BeanUtils.copyProperties(dto, entity);
        return this.saveOrUpdate(entity);
    }

    @Override
    public JDRYTZCSJLB update(JDRYTZCSJLBUpdateDTO dto) {
        Optional<JDRYTZCSJLB> optional = this.getById(dto.getBH());
        optional.ifPresent(JDRYTZCSJLB -> {
            BeanUtils.copyProperties(dto, JDRYTZCSJLB);
            this.saveOrUpdate(JDRYTZCSJLB);
        });
        return optional.orElse(null);
    }

    @Override
    public JDRYTZCSJLBVO getVOById(String id) {
        Optional<JDRYTZCSJLB> optional = this.getById(id);
        JDRYTZCSJLBVO JDRYTZCSJLBVO = new JDRYTZCSJLBVO();
        List<ResourceVO> resourceVOS = new ArrayList<>();
        optional.ifPresent(entity -> {
            BeanUtils.copyProperties(entity, JDRYTZCSJLBVO);
        });
        return JDRYTZCSJLBVO;
    }
}
