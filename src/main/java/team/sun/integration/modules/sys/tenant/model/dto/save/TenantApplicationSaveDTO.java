package team.sun.integration.modules.sys.tenant.model.dto.save;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.tenant.model.enums.TenantApplicationAction;

import javax.persistence.Convert;
import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 中间表：租户-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-23
 */

@ApiModel(value = "TenantApplicationMid-save", description = "修改-保存对象")
public class TenantApplicationSaveDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户")
    private String tenantId;

    @ApiModelProperty(value = "应用")
    private String applicationId;

    @ApiModelProperty(value = "可用天数")
    private Integer days;

    @ApiModelProperty(value = "使用状态（永久可用、使用中、已到期、已禁用）")
    @Convert(converter = TenantApplicationAction.Convert.class)
    private Integer state;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
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

}