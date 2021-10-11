package team.sun.integration.modules.sys.role.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.group.model.entity.Group;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.resource.model.entity.Element;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-角色：	角色关联单位
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@Table(name = "sys_role")
@SQLDelete(sql = "update sys_role set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "Role-relation", attributeNodes = {
        @NamedAttributeNode("roleResources"),
        @NamedAttributeNode("roleElements"),
        @NamedAttributeNode("users"),
        @NamedAttributeNode("groups")
}))
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "role_id")
    private String id;

    /**
     * 多对多：角色-菜单
     **/
    @ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_role_resource_mid",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private Set<Resource> roleResources = new HashSet<>();

    /**
     * 多对多：角色-菜单页面元素
     **/
    @ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_role_element_mid",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "element_id")
    )
    private Set<Element> roleElements = new HashSet<>();


    /**
     * 多对多：角色-用户
     **/
    @ManyToMany(mappedBy = "userRoles", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    /**
     * 多对多：角色-用户组
     **/
    @ManyToMany(mappedBy = "groupRoles", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Group> groups = new HashSet<>();


    /**
     * 编号
     */
    @Column(name = "code")
    private String code;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 是否可用：0不可用 1可用
     */
    @Column(name = "available")
    private Boolean available;

    /**
     * 备注说明
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 一对一： 创建人
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", unique = true)
    private User creator;

    /**
     * 一对一： 创建人所属部门
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_department_id", unique = true)
    private Org creatorDepartment;

    /**
     * 一对一： 创建人所属租户
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_tenant_id", unique = true)
    private Tenant creatorTenant;

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
        return "Role{" +
                "id='" + id + '\'' +
                ", roleResources=" + roleResources +
                ", RoleElements=" + roleElements +
                ", users=" + users +
                ", groups=" + groups +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", remarks='" + remarks + '\'' +
                ", creator=" + creator +
                ", creatorDepartment=" + creatorDepartment +
                ", creatorTenant=" + creatorTenant +
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

    public Set<Resource> getRoleResources() {
        return roleResources;
    }

    public void setRoleResources(Set<Resource> roleResources) {
        this.roleResources = roleResources;
    }

    public Set<Element> getRoleElements() {
        return roleElements;
    }

    public void setRoleElements(Set<Element> roleElements) {
        roleElements = roleElements;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Org getCreatorDepartment() {
        return creatorDepartment;
    }

    public void setCreatorDepartment(Org creatorDepartment) {
        this.creatorDepartment = creatorDepartment;
    }

    public Tenant getCreatorTenant() {
        return creatorTenant;
    }

    public void setCreatorTenant(Tenant creatorTenant) {
        this.creatorTenant = creatorTenant;
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
