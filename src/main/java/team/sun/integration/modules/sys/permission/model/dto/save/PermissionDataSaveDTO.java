package team.sun.integration.modules.sys.permission.model.dto.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 系统-数据权限表
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@ApiModel(value = "PermissionDataSave对象", description = "系统-数据权限表-保存")
public class PermissionDataSaveDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单")
    private String resourceId;

    @ApiModelProperty(value = "应用")
    private String applicationId;

    @ApiModelProperty(value = "租户")
    private String tenantId;

    @ApiModelProperty(value = "基础数据权限、数据权限共享")
    private Integer type;

    @ApiModelProperty(value = "私有、公开只读、公开读写")
    private Integer permissionType;

    @ApiModelProperty(value = "数据来源-用户")
    private String sourceUserId;

    @ApiModelProperty(value = "数据来源-用户组")
    private String sourceGroupId;

    @ApiModelProperty(value = "数据来源-部门")
    private String sourceDepartmentId;

    @ApiModelProperty(value = "共享数据-用户")
    private String shareUserId;

    @ApiModelProperty(value = "共享数据-用户组")
    private String shareGroupId;

    @ApiModelProperty(value = "共享数据-部门")
    private String shareDepartmentId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(String sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public String getSourceGroupId() {
        return sourceGroupId;
    }

    public void setSourceGroupId(String sourceGroupId) {
        this.sourceGroupId = sourceGroupId;
    }

    public String getSourceDepartmentId() {
        return sourceDepartmentId;
    }

    public void setSourceDepartmentId(String sourceDepartmentId) {
        this.sourceDepartmentId = sourceDepartmentId;
    }

    public String getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(String shareUserId) {
        this.shareUserId = shareUserId;
    }

    public String getShareGroupId() {
        return shareGroupId;
    }

    public void setShareGroupId(String shareGroupId) {
        this.shareGroupId = shareGroupId;
    }

    public String getShareDepartmentId() {
        return shareDepartmentId;
    }

    public void setShareDepartmentId(String shareDepartmentId) {
        this.shareDepartmentId = shareDepartmentId;
    }

}