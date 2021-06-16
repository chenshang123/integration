package team.sun.integration.modules.sys.group.model.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.user.model.entity.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-用户组：	组具有自己的角色信息、权限信息
 * </p>
 *
 * @author auto generator
 * @since 2021-02-01
 */
@Entity
@Table(name = "sys_group")
@SQLDelete(sql = "update sys_group set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /**
     * 多对多：用户组-单位（数据权限）
     **/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_group_data_node_mid",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "org_id")
    )
    private Set<Org> groupDataNodes = new HashSet<>();

    /**
     * 多对多：用户组-角色
     **/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_group_role_mid",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> groupRoles = new HashSet<>();

    /**
     * 多对多：用户组-用户
     **/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_group_user_mid",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> groupUsers = new HashSet<>();

    /**
     * 分组名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time", updatable = false, nullable = false)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;

    /**
     * 0正常 1删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    private Integer version;

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", groupDataNodes=" + groupDataNodes +
                ", groupRoles=" + groupRoles +
                ", groupUsers=" + groupUsers +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                ", version=" + version +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Org> getGroupDataNodes() {
        return groupDataNodes;
    }

    public void setGroupDataNodes(Set<Org> groupDataNodes) {
        this.groupDataNodes = groupDataNodes;
    }

    public Set<Role> getGroupRoles() {
        return groupRoles;
    }

    public void setGroupRoles(Set<Role> groupRoles) {
        this.groupRoles = groupRoles;
    }

    public Set<User> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(Set<User> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
