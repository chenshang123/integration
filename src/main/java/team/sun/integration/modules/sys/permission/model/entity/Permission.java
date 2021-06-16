package team.sun.integration.modules.sys.permission.model.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.role.model.entity.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-权限表
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@Table(name = "sys_permission")
@SQLDelete(sql = "update sys_permission set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /**
     * 多对多：用户-权限
     **/
    @ManyToMany(mappedBy = "rolePermissions", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();


    /**
     * 多对多：权限-资源（菜单）
     **/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_permission_resource_mid",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private Set<Resource> permissionResources = new HashSet<>();

    /**
     * 权限类型
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 权限名称
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
        return "Permission{" +
                "id='" + id + '\'' +
                //", roles=" + roles +
                ", permissionResources=" + permissionResources +
                ", type=" + type +
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Resource> getPermissionResources() {
        return permissionResources;
    }

    public void setPermissionResources(Set<Resource> permissionResources) {
        this.permissionResources = permissionResources;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
