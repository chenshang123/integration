package team.sun.integration.modules.sys.resource.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.role.model.vo.RoleVO;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;

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

@ApiModel(value = "ElementPageVO", description = "系统-菜单页面元素：详情")
public class ElementVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "多对多：资源（菜单页面元素）-角色")
    private Set<RoleVO> roles = new HashSet<>();

    @ApiModelProperty(value = "多对多：资源（菜单页面元素）-租户")
    private Set<TenantVO> tenants = new HashSet<>();

    @ApiModelProperty(value = "多对一：菜单页面元素-菜单")
    private ResourceVO resource;

    @ApiModelProperty(value = "页面元素名称")
    private String elementName;

    @ApiModelProperty(value = "页面元素标识")
    private String elementIdentify;

    @ApiModelProperty(value = "创建人所属部门")
    private String creatorDepartmentId;

    @ApiModelProperty(value = "创建人所属租户")
    private String creatorTenantId;

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
        return "ElementVO{" +
                "id='" + id + '\'' +
                ", roles=" + roles +
                ", tenants=" + tenants +
                ", resource=" + resource +
                ", elementName='" + elementName + '\'' +
                ", elementIdentify='" + elementIdentify + '\'' +
                ", creatorDepartmentId='" + creatorDepartmentId + '\'' +
                ", creatorTenantId='" + creatorTenantId + '\'' +
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

    public Set<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleVO> roles) {
        this.roles = roles;
    }

    public Set<TenantVO> getTenants() {
        return tenants;
    }

    public void setTenants(Set<TenantVO> tenants) {
        this.tenants = tenants;
    }

    public ResourceVO getResource() {
        return resource;
    }

    public void setResource(ResourceVO resource) {
        this.resource = resource;
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
