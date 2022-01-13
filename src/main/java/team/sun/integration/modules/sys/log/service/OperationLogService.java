package team.sun.integration.modules.sys.log.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.sys.log.model.dto.save.OperationLogSaveDTO;
import team.sun.integration.modules.sys.log.model.dto.update.OperationLogUpdateDTO;
import team.sun.integration.modules.sys.log.model.entity.OperationLog;

/**
 * <p>
 * 系统-操作日志：	1.日志包含时间、地点（方法）、人物	2.还原操作，记录参数、影响内容 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface OperationLogService extends IService<OperationLog, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    OperationLog save(OperationLogSaveDTO entity);

    OperationLog update(OperationLogUpdateDTO entity);
}
