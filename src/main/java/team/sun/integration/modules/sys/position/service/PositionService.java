package team.sun.integration.modules.sys.position.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.application.model.dto.save.ApplicationSaveDTO;
import team.sun.integration.modules.sys.application.model.dto.update.ApplicationUpdateDTO;
import team.sun.integration.modules.sys.application.model.entity.Application;
import team.sun.integration.modules.sys.position.model.dto.save.PositionSaveDTO;
import team.sun.integration.modules.sys.position.model.dto.update.PositionUpdateDTO;
import team.sun.integration.modules.sys.position.model.entity.Position;

/**
 * <p>
 * 系统-职位
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
public interface PositionService extends IService<Position, String> {
    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);
    Position save(PositionSaveDTO entity);
    Position update(PositionUpdateDTO entity);
}
