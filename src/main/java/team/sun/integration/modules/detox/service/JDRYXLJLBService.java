package team.sun.integration.modules.detox.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.detox.model.dto.save.JDRYXLJLBSaveDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYXLJLBUpdateDTO;
import team.sun.integration.modules.detox.model.entity.JDRYXLJLB;
import team.sun.integration.modules.detox.model.vo.JDRYXLJLBVO;


/**
 * <p>
 * 戒毒-人员训练记录 服务类
 * </p>
 *
 * @author auto generator
 * @since 2022-01-11
 */
public interface JDRYXLJLBService extends IService<JDRYXLJLB, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    JDRYXLJLB save(JDRYXLJLBSaveDTO entity);

    JDRYXLJLB update(JDRYXLJLBUpdateDTO entity);

    JDRYXLJLBVO getVOById(String id);
}
