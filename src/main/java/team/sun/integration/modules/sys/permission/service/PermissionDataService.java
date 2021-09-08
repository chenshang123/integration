package team.sun.integration.modules.sys.permission.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.permission.model.dto.save.PermissionDataSaveDTO;
import team.sun.integration.modules.sys.permission.model.dto.update.PermissionDataUpdateDTO;
import team.sun.integration.modules.sys.permission.model.entity.PermissionData;

import java.util.List;

/**
 * <p>
 * 系统-数据权限表 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface PermissionDataService extends IService<PermissionData, String> {


    /**
     * 获取可选的权限列表
     *
     * @return
     */
    List<PermissionData> getPermissionList();

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    PermissionData save(PermissionDataSaveDTO entity);

    PermissionData update(PermissionDataUpdateDTO entity);
}
