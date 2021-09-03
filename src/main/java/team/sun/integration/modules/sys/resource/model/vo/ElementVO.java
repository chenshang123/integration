package team.sun.integration.modules.sys.resource.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.user.model.entity.User;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-菜单页面元素：详情
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@ApiModel(value="ElementPageVO", description="系统-菜单页面元素：详情")
public class ElementVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "多对多：资源（菜单页面元素）-角色")
    private Set<Role> roles = new HashSet<>();

    @ApiModelProperty(value = "多对多：资源（菜单页面元素）-租户")
    private Set<Tenant> tenants = new HashSet<>();

    @ApiModelProperty(value = "多对一：菜单页面元素-菜单")
    private Resource elementResource;

    @ApiModelProperty(value = "页面元素名称")
    private String elementName;

    @ApiModelProperty(value = "页面元素标识")
    private String elementIdentify;

    @ApiModelProperty(value = "一对一： 创建人")
    private User creator;

    @ApiModelProperty(value = "一对一： 创建人所属部门")
    private Org department;

    @ApiModelProperty(value = "一对一： 创建人所属租户")
    private Tenant tenant;

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
        return "Element{" +
                "id='" + id + '\'' +
                ", roles=" + roles +
                ", tenants=" + tenants +
                ", elementResource=" + elementResource +
                ", elementName='" + elementName + '\'' +
                ", elementIdentify='" + elementIdentify + '\'' +
                ", creator=" + creator +
                ", department=" + department +
                ", tenant=" + tenant +
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

    public Set<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(Set<Tenant> tenants) {
        this.tenants = tenants;
    }

    public Resource getElementResource() {
        return elementResource;
    }

    public void setElementResource(Resource elementResource) {
        this.elementResource = elementResource;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementIdentify() {
        return elementIdentify;
    }

    public void setElementIdentify(String elementIdentify) {
        this.elementIdentify = elementIdentify;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Org getDepartment() {
        return department;
    }

    public void setDepartment(Org department) {
        this.department = department;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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
