package team.sun.integration.modules.sys.user.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.sys.user.model.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface UserDao extends IDao<User, String> {

    @Query(value = "select role_id from sys_user_role_mid where user_id = ?1", nativeQuery = true)
    List<String> findRoleIds(String userId);

    @EntityGraph(attributePaths = "userRoles")
    User findByUsername(String userName);

}
