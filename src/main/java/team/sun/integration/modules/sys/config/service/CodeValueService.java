package team.sun.integration.modules.sys.config.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.service.IService;
import team.sun.integration.modules.sys.config.model.dto.save.CodeValueSaveDTO;
import team.sun.integration.modules.sys.config.model.dto.update.CodeValueUpdateDTO;
import team.sun.integration.modules.sys.config.model.entity.CodeValue;

/**
 * <p>
 * 系统-码值 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-03-03
 */
public interface CodeValueService extends IService<CodeValue, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    CodeValue save(CodeValueSaveDTO entity);

    CodeValue update(CodeValueUpdateDTO entity);
}
