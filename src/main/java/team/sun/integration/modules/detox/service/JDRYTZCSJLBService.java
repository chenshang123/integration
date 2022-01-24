package team.sun.integration.modules.detox.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.detox.model.dto.save.JDRYTZCSJLBSaveDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYTZCSJLBUpdateDTO;
import team.sun.integration.modules.detox.model.entity.JDRYTZCSJLB;
import team.sun.integration.modules.detox.model.vo.JDRYTZCSJLBVO;

import java.util.List;

/**
 * <p>
 * 戒毒-人员体质测试 服务类
 * </p>
 *
 * @author auto generator
 * @since 2022-01-11
 */
public interface JDRYTZCSJLBService extends IService<JDRYTZCSJLB, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    JDRYTZCSJLB save(JDRYTZCSJLBSaveDTO entity);

    JDRYTZCSJLB update(JDRYTZCSJLBUpdateDTO entity);

    JDRYTZCSJLBVO getVOById(String id);
}
