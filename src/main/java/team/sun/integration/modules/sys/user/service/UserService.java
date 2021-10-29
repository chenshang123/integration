package team.sun.integration.modules.sys.user.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.user.model.dto.save.UserSaveDTO;
import team.sun.integration.modules.sys.user.model.dto.update.UserUpdateDTO;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.sys.user.model.vo.UserVO;
import team.sun.integration.modules.sys.user.model.vo.login.UserLoginVO;

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

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    User save(UserSaveDTO dto);

    User update(UserUpdateDTO dto);

    UserVO getUserById(String id);

    List<String> getRoleIds(String userId);

    //授权
    void authZRole(String userId, List<String> roleIds);

    UserLoginVO getByUsername(String username, Boolean withRoles);

    boolean verifyPassword(String password, String rawPassword);


}
