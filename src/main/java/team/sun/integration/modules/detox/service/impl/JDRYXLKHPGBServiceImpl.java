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
import team.sun.integration.modules.detox.model.dto.save.JDRYXLKHPGBSaveDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYXLKHPGBUpdateDTO;
import team.sun.integration.modules.detox.model.entity.JDRYXLKHPGB;
import team.sun.integration.modules.detox.model.entity.QJDRYXLKHPGB;
import team.sun.integration.modules.detox.model.vo.JDRYXLKHPGBVO;
import team.sun.integration.modules.detox.model.vo.page.JDRYXLKHPGBPageVO;
import team.sun.integration.modules.detox.repository.JDRYXLKHPGBDao;
import team.sun.integration.modules.detox.service.JDRYXLKHPGBService;
import team.sun.integration.modules.sys.resource.model.vo.ResourceVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 戒毒-人员员训练考核评估
 * </p>
 *
 * @author auto generator
 * @since 2022-01-14
 */
@Service
public class JDRYXLKHPGBServiceImpl extends ServiceImpl<JDRYXLKHPGBDao, JDRYXLKHPGB> implements JDRYXLKHPGBService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QJDRYXLKHPGB qJDRYXLKHPGB = QJDRYXLKHPGB.jDRYXLKHPGB;
        BlazeJPAQuery<JDRYXLKHPGB> blazeJPAQuery = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory)
                .from(qJDRYXLKHPGB)
                .select(qJDRYXLKHPGB)
                .where(predicate).orderBy(qJDRYXLKHPGB.BH.asc().nullsLast());
        PagedList<JDRYXLKHPGB> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        List<JDRYXLKHPGBPageVO> pageVOS = new ArrayList<>();
        pages.forEach(entity -> {
            JDRYXLKHPGBPageVO pageVO = new JDRYXLKHPGBPageVO();
            BeanUtils.copyProperties(entity, pageVO);
            pageVOS.add(pageVO);
        });

        return new PageRet(pageVOS, pages.getTotalSize());
    }

    @Override
    public JDRYXLKHPGB save(JDRYXLKHPGBSaveDTO dto) {
        JDRYXLKHPGB entity = new JDRYXLKHPGB();
        BeanUtils.copyProperties(dto, entity);
        return this.saveOrUpdate(entity);
    }

    @Override
    public JDRYXLKHPGB update(JDRYXLKHPGBUpdateDTO dto) {
        Optional<JDRYXLKHPGB> optional = this.getById(dto.getBH());
        optional.ifPresent(JDRYXLKHPGB -> {
            BeanUtils.copyProperties(dto, JDRYXLKHPGB);
            this.saveOrUpdate(JDRYXLKHPGB);
        });
        return optional.orElse(null);
    }

    @Override
    public JDRYXLKHPGBVO getVOById(String id) {
        Optional<JDRYXLKHPGB> optional = this.getById(id);
        JDRYXLKHPGBVO JDRYXLKHPGBVO = new JDRYXLKHPGBVO();
        List<ResourceVO> resourceVOS = new ArrayList<>();
        optional.ifPresent(entity -> {
            BeanUtils.copyProperties(entity, JDRYXLKHPGBVO);
        });
        return JDRYXLKHPGBVO;
    }
}
