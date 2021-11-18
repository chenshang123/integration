package team.sun.integration.modules.sys.tenant.service.impl;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import team.sun.integration.modules.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.tenant.model.entity.TenantApplication;
import team.sun.integration.modules.sys.tenant.model.vo.TenantApplicationVO;
import team.sun.integration.modules.sys.tenant.repository.TenantApplicationDao;
import team.sun.integration.modules.sys.tenant.service.TenantApplicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-租户
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
@Service
public class TenantApplicationServiceImpl extends ServiceImpl<TenantApplicationDao, TenantApplication> implements TenantApplicationService {


    @Override
    public List<TenantApplicationVO> getApplication(Predicate predicate) {
        Iterable<TenantApplication> iterable = this.get(predicate);
        List<TenantApplicationVO> vos  = new ArrayList<>();
        iterable.forEach(item -> {
            TenantApplicationVO vo = new TenantApplicationVO();
            BeanUtils.copyProperties(item, vo);
            vos.add(vo);
        });
        return vos;
    }

    @Override
    public TenantApplicationVO getVO(String id) {
        Optional<TenantApplication> optional = this.getById(id);
        TenantApplicationVO vo = new TenantApplicationVO();
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, vo));
        return vo;
    }
}
