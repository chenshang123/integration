package team.sun.integration.modules.sys.permission.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 系统-权限表
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sys_permission_data")
@SQLDelete(sql = "update sys_permission_data set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class PermissionData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "permission_data_id")
    private String id;
    /**
     * 菜单
     */
    @Column(name = "resource_id")
    private String resourceId;

    /**
     * 应用
     */
    @Column(name = "application_id")
    private String applicationId;

    /**
     * 租户
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 基础数据权限、数据权限共享
     */

    @Column(name = "type")
    private Integer type;

    /**
     * 私有、公开只读、公开读写
     */
    @Column(name = "permission_type")
    private Integer permissionType;

    /**
     * 数据来源-用户
     */
    @Column(name = "source_user_id")
    private String sourceUserId;

    /**
     * 数据来源-用户组
     */
    @Column(name = "source_group_id")
    private String sourceGroupId;

    /**
     * 数据来源-部门
     */
    @Column(name = "source_department_id")
    private String sourceDepartmentId;

    /**
     * 共享数据-用户
     */
    @Column(name = "share_user_id")
    private String shareUserId;

    /**
     * 共享数据-用户组
     */
    @Column(name = "share_group_id")
    private String shareGroupId;

    /**
     * 共享数据-部门
     */
    @Column(name = "share_department_id")
    private String shareDepartmentId;

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
        return "PermissionData{" +
                "id='" + id + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", type=" + type +
                ", permissionType=" + permissionType +
                ", sourceUserId='" + sourceUserId + '\'' +
                ", sourceGroupId='" + sourceGroupId + '\'' +
                ", sourceDepartmentId='" + sourceDepartmentId + '\'' +
                ", shareUserId='" + shareUserId + '\'' +
                ", shareGroupId='" + shareGroupId + '\'' +
                ", shareDepartmentId='" + shareDepartmentId + '\'' +
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
