package team.sun.integration.modules.sys.permission.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.permission.model.entity.PermissionData;

import java.util.Optional;

/**
 * <p>
 * 系统-权限表 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Repository
public interface PermissionDataDao extends IDao<PermissionData, String> {

    @Override
    @EntityGraph("PermissionData-relation")
    Optional<PermissionData> findById(String id);
}
