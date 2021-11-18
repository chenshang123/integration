package team.sun.integration.modules.sys.log.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.sys.log.model.entity.OperationLog;

import java.util.Optional;

/**
 * <p>
 * 系统-操作日志：	1.日志包含时间、地点（方法）、人物	2.还原操作，记录参数、影响内容 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Repository
public interface OperationLogDao extends IDao<OperationLog, String> {

    @Override
    @EntityGraph("OperationLog-relation")
    Optional<OperationLog> findById(String id);
}
