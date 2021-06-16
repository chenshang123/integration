package team.sun.integration.modules.sys.user.repository;

import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.sys.user.model.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends IDao<User, String> {


    @Query(value = "select role_id from sys_user_role_mid where user_id = ?1", nativeQuery = true)
    List<String> findRoleIds(String userId);

    List<User> findByUsername(String userName);

}
