package team.sun.integration.modules.sys.tenant.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.application.model.entity.Application;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.user.model.entity.User;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 中间表：租户-应用：详情
 * </p>
 *
 * @author auto generator
 * @since 2021-08-23
 */

@ApiModel(value="TenantApplicationPageVO", description="租户-应用：详情")
public class TenantApplicationVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "多对多转多对一：租户-应用")
    private Tenant tenant;


    @ApiModelProperty(value = "多对多转多对一：租户-应用")
    private Application application;

    @ApiModelProperty(value = "可用天数")
    private Integer days;

    @ApiModelProperty(value = "使用状态（永久可用、使用中、已到期、已禁用）")
    private Integer state;

    @ApiModelProperty(value = "一对一： 创建人")
    private User creator;

    @ApiModelProperty(value = "一对一： 创建人所属部门")
    private Org department;

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
        return "TenantApplication{" +
                "id='" + id + '\'' +
                ", tenant=" + tenant +
                ", application=" + application +
                ", days=" + days +
                ", state=" + state +
                ", creator=" + creator +
                ", department=" + department +
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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
