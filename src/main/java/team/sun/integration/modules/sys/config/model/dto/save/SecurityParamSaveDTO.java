package team.sun.integration.modules.sys.config.model.dto.save;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统-参数配置
 * </p>
 *
 * @author auto generator
 * @since 2021-02-24
 */

@ApiModel(value = "SysSecurityParam对象", description = "系统-参数配置")
public class SecurityParamSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "口令期限-秒")
    private Integer pwdTimes;

    @ApiModelProperty(value = "会话过期时间-秒")
    private Integer sessionTimeout;

    @ApiModelProperty(value = "最大会话")
    private Integer maxSession;

    @ApiModelProperty(value = "登录失败次数限制")
    private Integer faultLimit;

    @ApiModelProperty(value = "锁定时间-秒")
    private Integer lockTime;

    @ApiModelProperty(value = "账号扫描周期-秒")
    private Integer scanCycle;

    @ApiModelProperty(value = "日志存量大小")
    private Integer logDataUp;

    @ApiModelProperty(value = "临时账号有效期-秒")
    private Integer tempAccount;

    @ApiModelProperty(value = "账号进入休眠（账号未登录时间-秒）")
    private Integer sleepAccount;

    @ApiModelProperty(value = "允许访问时段-开始")
    private LocalDateTime allowAccess;

    @ApiModelProperty(value = "允许访问时段-结束")
    private LocalDateTime allowNotAccess;

    @ApiModelProperty(value = "登录网段：（*.*.*.0-255）星号代表0-255")
    private String networkSegment;

    @ApiModelProperty(value = "是否有手动激活")
    private Boolean hasActive;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "0正常 1删除")
    private Boolean delFlag;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPwdTimes() {
        return pwdTimes;
    }

    public void setPwdTimes(Integer pwdTimes) {
        this.pwdTimes = pwdTimes;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public Integer getMaxSession() {
        return maxSession;
    }

    public void setMaxSession(Integer maxSession) {
        this.maxSession = maxSession;
    }

    public Integer getFaultLimit() {
        return faultLimit;
    }

    public void setFaultLimit(Integer faultLimit) {
        this.faultLimit = faultLimit;
    }

    public Integer getLockTime() {
        return lockTime;
    }

    public void setLockTime(Integer lockTime) {
        this.lockTime = lockTime;
    }

    public Integer getScanCycle() {
        return scanCycle;
    }

    public void setScanCycle(Integer scanCycle) {
        this.scanCycle = scanCycle;
    }

    public Integer getLogDataUp() {
        return logDataUp;
    }

    public void setLogDataUp(Integer logDataUp) {
        this.logDataUp = logDataUp;
    }

    public Integer getTempAccount() {
        return tempAccount;
    }

    public void setTempAccount(Integer tempAccount) {
        this.tempAccount = tempAccount;
    }

    public Integer getSleepAccount() {
        return sleepAccount;
    }

    public void setSleepAccount(Integer sleepAccount) {
        this.sleepAccount = sleepAccount;
    }

    public LocalDateTime getAllowAccess() {
        return allowAccess;
    }

    public void setAllowAccess(LocalDateTime allowAccess) {
        this.allowAccess = allowAccess;
    }

    public LocalDateTime getAllowNotAccess() {
        return allowNotAccess;
    }

    public void setAllowNotAccess(LocalDateTime allowNotAccess) {
        this.allowNotAccess = allowNotAccess;
    }

    public String getNetworkSegment() {
        return networkSegment;
    }

    public void setNetworkSegment(String networkSegment) {
        this.networkSegment = networkSegment;
    }

    public Boolean getHasActive() {
        return hasActive;
    }

    public void setHasActive(Boolean hasActive) {
        this.hasActive = hasActive;
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