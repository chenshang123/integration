package team.sun.integration.modules.sys.resource.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.application.model.vo.ApplicationVO;
import team.sun.integration.modules.sys.org.model.vo.OrgVO;
import team.sun.integration.modules.sys.resource.model.enums.ResourceType;
import team.sun.integration.modules.sys.resource.model.enums.ResourceVisitType;
import team.sun.integration.modules.sys.role.model.vo.RoleVO;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;
import team.sun.integration.modules.sys.user.model.vo.UserVO;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-菜单：详情
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@ApiModel(value = "ResourceVO", description = "系统-菜单：详情")
public class ResourceVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "一对多：菜单-页面元素")
    private Set<ElementVO> elements = new HashSet<>();

    @ApiModelProperty(value = "多对多：资源（菜单）-角色")
    private Set<RoleVO> roles = new HashSet<>();

    @ApiModelProperty(value = "多对一：资源（菜单）-应用")
    private ApplicationVO application;

    @ApiModelProperty(value = "多对多：资源（菜单）-租户")
    private Set<TenantVO> tenants = new HashSet<>();

    @ApiModelProperty(value = "首层id")
    private String firstFloorId;

    @ApiModelProperty(value = "父级菜单id")
    private String parentId;

    @ApiModelProperty(value = "层级")
    private Integer layer;

    @ApiModelProperty(value = "顺序 越小优先级越高 默认0")
    private Integer weight;

    @ApiModelProperty(value = "隐藏编号（id1_id2_id3_...当前层级以上节点id）")
    private String hiddenCode;

    @ApiModelProperty(value = "菜单名称(英文)")
    private String name;

    @ApiModelProperty(value = "显示名称(中文)")
    private String title;

    @ApiModelProperty(value = "权限代码")
    private String permission;

    @ApiModelProperty(value = "接口地址")
    private String path;

    @ApiModelProperty(value = "前端组件路径")
    private String component;

    @ApiModelProperty(value = "类型（按钮、菜单）")
    private ResourceType type;

    @ApiModelProperty(value = "访问类型(get/post/put/)")
    private ResourceVisitType visitType;

    @ApiModelProperty(value = "创建人所属部门")
    private String creatorDepartmentId;

    @ApiModelProperty(value = "创建人")
    private String creatorId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "0正常 1删除")
    private Boolean delFlag;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @Override
    public String toString() {
        return "ResourceVO{" +
                "id='" + id + '\'' +
                ", elements=" + elements +
                ", roles=" + roles +
                ", application=" + application +
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
                ", creatorDepartmentId='" + creatorDepartmentId + '\'' +
                ", creatorId='" + creatorId + '\'' +
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

    public Set<ElementVO> getElements() {
        return elements;
    }

    public void setElements(Set<ElementVO> elements) {
        this.elements = elements;
    }

    public Set<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleVO> roles) {
        this.roles = roles;
    }

    public ApplicationVO getApplication() {
        return application;
    }

    public void setApplication(ApplicationVO application) {
        this.application = application;
    }

    public Set<TenantVO> getTenants() {
        return tenants;
    }

    public void setTenants(Set<TenantVO> tenants) {
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

    public String getCreatorDepartmentId() {
        return creatorDepartmentId;
    }

    public void setCreatorDepartmentId(String creatorDepartmentId) {
        this.creatorDepartmentId = creatorDepartmentId;
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