package team.sun.integration.modules.sys.role.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.group.model.entity.Group;
import team.sun.integration.modules.sys.resource.model.entity.Element;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sys_role")
@SQLDelete(sql = "update sys_role set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "Role-relation", attributeNodes = {
        @NamedAttributeNode("resources"),
        @NamedAttributeNode("elements"),
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
            name = "sys_role_mid_resource",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private Set<Resource> resources;

    /**
     * 多对多：角色-菜单页面元素
     **/
    @ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_role_mid_element",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "element_id")
    )
    private Set<Element> elements;


    /**
     * 多对多：角色-用户
     **/
    @ManyToMany(mappedBy = "roles", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<User> users;

    /**
     * 多对多：角色-用户组
     **/
    @ManyToMany(mappedBy = "roles", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Group> groups;


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
     * 一对一： 创建人所属部门
     */
    @Column(name = "creator_department_id")
    private String creatorDepartmentId;

    /**
     * 一对一： 创建人所属租户
     */
    @Column(name = "creator_tenant_Id")
    private String creatorTenantId;

    /**
     * 一对一： 创建人
     */
    @CreatedBy
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time", updatable = false, nullable = false)
    private LocalDateTime createTime;

    /**
     * 一对一： 最后修改人
     */
    @LastModifiedBy
    @Column(name = "modifier_id")
    private String modifierId;

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
    private Boolean delFlag = false;

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
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", remarks='" + remarks + '\'' +
                ", creatorDepartmentId='" + creatorDepartmentId + '\'' +
                ", creatorTenantId='" + creatorTenantId + '\'' +
                ", creatorId='" + creatorId + '\'' +
                ", createTime=" + createTime +
                ", modifierId='" + modifierId + '\'' +
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

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Set<Element> getElements() {
        return elements;
    }

    public void setElements(Set<Element> elements) {
        this.elements = elements;
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

    public String getCreatorDepartmentId() {
        return creatorDepartmentId;
    }

    public void setCreatorDepartmentId(String creatorDepartmentId) {
        this.creatorDepartmentId = creatorDepartmentId;
    }

    public String getCreatorTenantId() {
        return creatorTenantId;
    }

    public void setCreatorTenantId(String creatorTenantId) {
        this.creatorTenantId = creatorTenantId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
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
