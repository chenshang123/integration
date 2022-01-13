package team.sun.integration.modules.sys.application.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.sys.application.model.dto.save.ApplicationSaveDTO;
import team.sun.integration.modules.sys.application.model.dto.update.ApplicationUpdateDTO;
import team.sun.integration.modules.sys.application.model.entity.Application;
import team.sun.integration.modules.sys.application.model.vo.ApplicationVO;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
public interface ApplicationService extends IService<Application, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    Application save(ApplicationSaveDTO entity);

    Application update(ApplicationUpdateDTO entity);

    ApplicationVO getApplicationById(String id);

}
