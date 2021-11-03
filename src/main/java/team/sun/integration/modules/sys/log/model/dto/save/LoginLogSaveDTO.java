package team.sun.integration.modules.sys.log.model.dto.save;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 系统-登录日志
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@ApiModel(value = "loginLogSave对象", description = "系统-登录日志-保存")
public class LoginLogSaveDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "终端类型（chrome/google/微信小程序/APP）")
    private String terminalType;

    @ApiModelProperty(value = "操作系统（windows/linux/Android）")
    private String operationSystem;

    @ApiModelProperty(value = "ip地址")
    private String ip;

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}