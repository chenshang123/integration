package team.sun.integration.modules.sys.tenant.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.application.model.vo.ApplicationVO;
import team.sun.integration.modules.sys.org.model.vo.OrgVO;
import team.sun.integration.modules.sys.user.model.vo.UserVO;

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

@ApiModel(value = "TenantApplicationPageVO", description = "租户-应用：详情")
public class TenantApplicationVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "多对多转多对一：租户-应用")
    private TenantVO tenant;

    @ApiModelProperty(value = "多对多转多对一：租户-应用")
    private ApplicationVO application;

    @ApiModelProperty(value = "可用天数")
    private Integer days;

    @ApiModelProperty(value = "使用状态（永久可用、使用中、已到期、已禁用）")
    private Integer state;

    @ApiModelProperty(value = "一对一： 创建人")
    private UserVO creator;

    @ApiModelProperty(value = "一对一： 创建人所属部门")
    private OrgVO creatorDepartment;

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
        return "TenantApplicationVO{" +
                "id='" + id + '\'' +
                ", tenant=" + tenant +
                ", application=" + application +
                ", days=" + days +
                ", state=" + state +
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

    public TenantVO getTenant() {
        return tenant;
    }

    public void setTenant(TenantVO tenant) {
        this.tenant = tenant;
    }

    public ApplicationVO getApplication() {
        return application;
    }

    public void setApplication(ApplicationVO application) {
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

    public UserVO getCreator() {
        return creator;
    }

    public void setCreator(UserVO creator) {
        this.creator = creator;
    }

    public OrgVO getCreatorDepartment() {
        return creatorDepartment;
    }

    public void setCreatorDepartment(OrgVO creatorDepartment) {
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
