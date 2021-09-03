package team.sun.integration.modules.sys.user.model.vo.login;

import team.sun.integration.modules.sys.user.model.entity.User;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色
 */
public class UserLoginVO implements Serializable {

    private User user;

    private List<String> roleIds = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
