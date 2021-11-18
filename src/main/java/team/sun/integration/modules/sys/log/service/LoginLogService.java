package team.sun.integration.modules.sys.log.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.service.IService;
import team.sun.integration.modules.sys.log.model.dto.save.LoginLogSaveDTO;
import team.sun.integration.modules.sys.log.model.dto.update.LoginLogUpdateDTO;
import team.sun.integration.modules.sys.log.model.entity.LoginLog;

/**
 * <p>
 * 系统-登录日志
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface LoginLogService extends IService<LoginLog, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    LoginLog save(LoginLogSaveDTO entity);

    LoginLog update(LoginLogUpdateDTO entity);
}
