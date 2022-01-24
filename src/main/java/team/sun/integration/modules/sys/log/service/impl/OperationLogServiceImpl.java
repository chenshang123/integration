package team.sun.integration.modules.sys.log.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.log.model.dto.save.OperationLogSaveDTO;
import team.sun.integration.modules.sys.log.model.dto.update.OperationLogUpdateDTO;
import team.sun.integration.modules.sys.log.model.entity.OperationLog;
import team.sun.integration.modules.sys.log.model.entity.QOperationLog;
import team.sun.integration.modules.sys.log.repository.OperationLogDao;
import team.sun.integration.modules.sys.log.service.OperationLogService;

import java.util.Optional;

/**
 * <p>
 * 系统-操作日志：	1.日志包含时间、地点（方法）、人物	2.还原操作，记录参数、影响内容 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogDao, OperationLog> implements OperationLogService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QOperationLog qOperationLog = QOperationLog.operationLog;
        BlazeJPAQuery<OperationLog> blazeJPAQuery = new BlazeJPAQuery<OperationLog>(entityManager, criteriaBuilderFactory)
                .from(qOperationLog)
                .select(qOperationLog)
                .where(predicate).orderBy(qOperationLog.id.asc().nullsLast());
        PagedList<OperationLog> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalSize());
    }

    @Override
    public OperationLog save(OperationLogSaveDTO dto) {
        OperationLog entity = new OperationLog();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public OperationLog update(OperationLogUpdateDTO dto) {
        Optional<OperationLog> optional = this.getById(dto.getId());
        optional.ifPresent(OperationLog -> {
            BeanUtils.copyProperties(dto, OperationLog);
            this.dao.save(OperationLog);
        });
        return optional.orElse(null);
    }
}
