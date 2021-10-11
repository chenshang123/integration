package team.sun.integration.modules.sys.resource.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.application.model.entity.Application;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.resource.model.enums.ResourceType;
import team.sun.integration.modules.sys.resource.model.enums.ResourceVisitType;
import team.sun.integration.modules.sys.role.model.entity.Role;
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
 * 系统-菜单：
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@Table(name = "sys_resource")
@SQLDelete(sql = "update sys_resource set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "Resource-relation", attributeNodes = {
        @NamedAttributeNode("resourceElements"),
        @NamedAttributeNode("roles"),
        @NamedAttributeNode("applicationResource"),
        @NamedAttributeNode("tenants")
}))
public class Resource implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "resource_id")
    private String id;

    /**
     * 一对多：菜单-页面元素
     **/
    @OneToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY, mappedBy = "elementResource")
    private Set<Element> resourceElements = new HashSet<>();

    /**
     * 多对多：资源（菜单）-角色
     **/
    @ManyToMany(mappedBy = "roleResources", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();

    /**
     * 多对一：资源（菜单）-应用
     **/
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", referencedColumnName = "application_id")
    @JsonBackReference
    private Application applicationResource;

    /**
     * 多对多：资源（菜单）-租户
     **/
    @ManyToMany(mappedBy = "tenantResources", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Tenant> tenants = new HashSet<>();

    /**
     * 首层id
     */
    @Column(name = "first_floor_id")
    private String firstFloorId;

    /**
     * 父级菜单id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 层级
     */
    @Column(name = "layer")
    private Integer layer;

    /**
     * 顺序 越小优先级越高 默认0
     */
    @Column(name = "weight")
    private Integer weight;

    /**
     * 隐藏编号（id1_id2_id3_...当前层级以上节点id）
     */
    @Column(name = "hidden_code")
    private String hiddenCode;

    /**
     * 菜单名称(英文)
     */
    @Column(name = "name")
    private String name;

    /**
     * 显示名称(中文)
     */
    @Column(name = "title")
    private String title;

    /**
     * 权限代码
     */
    @Column(name = "permission")
    private String permission;

    /**
     * 接口地址
     */
    @Column(name = "path")
    private String path;

    /**
     * 前端组件路径
     */
    @Column(name = "component")
    private String component;

    /**
     * 类型（按钮、菜单）
     */
    @Convert(converter = ResourceType.Convert.class)
    @Column(name = "type")
    private ResourceType type;

    /**
     * 访问类型(get/post/put/)
     */
    @Convert(converter = ResourceVisitType.Convert.class)
    @Column(name = "visit_type")
    private ResourceVisitType visitType;

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
        return "Resource{" +
                "id='" + id + '\'' +
                ", resourceElements=" + resourceElements +
                ", roles=" + roles +
                ", applicationResource=" + applicationResource +
                ", tenants=" + tenants +
                ", firstFloorId='" + firstFloorId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", layer=" + layer +
                ", weight=" + weight +
                ", hiddenCode='" + hiddenCode + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", permission='" + permission + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", type=" + type +
                ", visitType=" + visitType +
                ", creator=" + creator +
                ", creatorDepartment=" + creatorDepartment +
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

    public Set<Element> getResourceElements() {
        return resourceElements;
    }

    public void setResourceElements(Set<Element> resourceElements) {
        this.resourceElements = resourceElements;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Application getApplicationResource() {
        return applicationResource;
    }

    public void setApplicationResource(Application applicationResource) {
        this.applicationResource = applicationResource;
    }

    public Set<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(Set<Tenant> tenants) {
        this.tenants = tenants;
    }

    public String getFirstFloorId() {
        return firstFloorId;
    }

    public void setFirstFloorId(String firstFloorId) {
        this.firstFloorId = firstFloorId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHiddenCode() {
        return hiddenCode;
    }

    public void setHiddenCode(String hiddenCode) {
        this.hiddenCode = hiddenCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public ResourceVisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(ResourceVisitType visitType) {
        this.visitType = visitType;
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