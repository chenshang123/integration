package team.sun.integration.modules.sys.config.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.config.model.dto.save.SecurityParamSaveDTO;
import team.sun.integration.modules.sys.config.model.dto.update.SecurityParamUpdateDTO;
import team.sun.integration.modules.sys.config.model.entity.SecurityParam;

/**
 * <p>
 * 系统-参数配置 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-24
 */
public interface SecurityParamService extends IService<SecurityParam, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    SecurityParam save(SecurityParamSaveDTO entity);

    SecurityParam update(SecurityParamUpdateDTO entity);
}
