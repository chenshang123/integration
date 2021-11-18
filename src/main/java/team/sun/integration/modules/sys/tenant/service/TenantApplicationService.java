package team.sun.integration.modules.sys.tenant.service;

import com.querydsl.core.types.Predicate;
import team.sun.integration.modules.base.service.IService;
import team.sun.integration.modules.sys.tenant.model.entity.TenantApplication;
import team.sun.integration.modules.sys.tenant.model.vo.TenantApplicationVO;

import java.util.List;

/**
 * <p>
 * 系统-租户应用状态记录表
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
public interface TenantApplicationService extends IService<TenantApplication, String> {

    List<TenantApplicationVO> getApplication(Predicate predicate);

    TenantApplicationVO getVO(String id);
}
