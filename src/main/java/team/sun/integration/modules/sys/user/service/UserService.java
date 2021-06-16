package team.sun.integration.modules.sys.user.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.service.IService;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.sys.user.model.vo.UserRoleVO;
import team.sun.integration.modules.sys.user.model.vo.page.UserPageVo;

import java.util.List;

/**
 * <p>
 * 系统-用户 服务类
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */
public interface UserService extends IService<User, String> {

    PageRet<UserPageVo> page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    List<String> getRoleIds(String userId);

    //授权
    void authZRole(String userId, List<String> roleIds);

    UserRoleVO getByUsername(String username, boolean withRoles);

    boolean verifyPassword(String password, String rawPassword);

    User save(User entity);

    User update(User entity);
}
