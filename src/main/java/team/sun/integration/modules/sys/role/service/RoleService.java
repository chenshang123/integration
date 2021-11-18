package team.sun.integration.modules.sys.role.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.service.IService;
import team.sun.integration.modules.sys.role.model.dto.save.RoleSaveDTO;
import team.sun.integration.modules.sys.role.model.dto.update.RoleUpdateDTO;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.role.model.vo.RoleVO;

import java.util.List;

/**
 * <p>
 * 系统-角色：	角色关联单位 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface RoleService extends IService<Role, String> {

    /**
     * 给角色授权菜单权限
     *
     * @param roleId      角色id
     * @param resourceIds 菜单权限ids
     */
    void authZ(String roleId, List<String> resourceIds);

    /**
     * 获取可选的角色列表
     *
     * @return 角色集合
     */
    List<Role> getRoleList();

    /**
     * 查询角色对应的资源操作权限
     *
     * @param roleIds 角色ids
     * @return 权限ids
     */
    List<String> findResourceIds(List<String> roleIds);

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    Role save(RoleSaveDTO entity);

    Role update(RoleUpdateDTO entity);

    RoleVO getRoleById(String id);
}
