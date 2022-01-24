package team.sun.integration.modules.detox.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.detox.model.dto.save.JDRYXLJLBSaveDTO;
import team.sun.integration.modules.detox.model.dto.save.JDRYXLKHPGBSaveDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYXLJLBUpdateDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYXLKHPGBUpdateDTO;
import team.sun.integration.modules.detox.model.entity.JDRYXLJLB;
import team.sun.integration.modules.detox.model.entity.JDRYXLKHPGB;
import team.sun.integration.modules.detox.model.vo.JDRYXLKHPGBVO;

import java.util.List;

/**
 * <p>
 * 戒毒-人员员训练考核评估 服务类
 * </p>
 *
 * @author auto generator
 * @since 2022-01-11
 */
public interface JDRYXLKHPGBService extends IService<JDRYXLKHPGB, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    JDRYXLKHPGB save(JDRYXLKHPGBSaveDTO entity);

    JDRYXLKHPGB update(JDRYXLKHPGBUpdateDTO entity);

    JDRYXLKHPGBVO getVOById(String id);
}
