package team.sun.integration.modules.sys.log.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.log.model.dto.save.LoginLogSaveDTO;
import team.sun.integration.modules.sys.log.model.dto.update.LoginLogUpdateDTO;
import team.sun.integration.modules.sys.log.model.entity.LoginLog;
import team.sun.integration.modules.sys.log.model.entity.QLoginLog;
import team.sun.integration.modules.sys.log.repository.LoginLogDao;
import team.sun.integration.modules.sys.log.service.LoginLogService;
import team.sun.integration.modules.sys.log.service.OperationLogService;

import java.util.Optional;

/**
 * <p>
 * 系统-登录日志
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogDao, LoginLog> implements LoginLogService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QLoginLog qLoginLog = QLoginLog.loginLog;
        BlazeJPAQuery<LoginLog> blazeJPAQuery = new BlazeJPAQuery<LoginLog>(entityManager, criteriaBuilderFactory)
                .from(qLoginLog)
                .select(qLoginLog)
                .where(predicate).orderBy(qLoginLog.id.asc().nullsLast());
        PagedList<LoginLog> loginLogs = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(loginLogs, loginLogs.getTotalSize());
    }

    @Override
    public LoginLog save(LoginLogSaveDTO dto) {
        LoginLog entity = new LoginLog();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public LoginLog update(LoginLogUpdateDTO dto) {
        Optional<LoginLog> optional = this.getById(dto.getId());
        optional.ifPresent(LoginLog -> {
            BeanUtils.copyProperties(dto, LoginLog);
            this.dao.save(LoginLog);
        });
        return optional.orElse(null);
    }
}
