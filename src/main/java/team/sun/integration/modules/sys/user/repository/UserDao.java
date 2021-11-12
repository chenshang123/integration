package team.sun.integration.modules.sys.user.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.sys.user.model.entity.User;

import java.util.Optional;

@Repository
public interface UserDao extends IDao<User, String> {

/*    @Query(value = "select role_id from sys_user_role_mid where user_id = ?1", nativeQuery = true)
    List<String> findRoleIds(String userId);*/

    @EntityGraph(attributePaths = "roles")
    User findByUsername(String userName);

    @Override
    @EntityGraph("User-relation")
    @NotNull
    Optional<User> findById(@NotNull String id);

}
