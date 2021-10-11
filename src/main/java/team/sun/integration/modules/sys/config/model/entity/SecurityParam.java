package team.sun.integration.modules.sys.config.model.entity;

import java.io.Serial;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;


/**
 * <p>
 * 系统-参数配置
 * </p>
 *
 * @author auto generator
 * @since 2021-02-24
 */
@Entity
@Table(name = "sys_security_param")
public class SecurityParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "security_param_id")
    private String id;

    /**
     * 口令期限-秒
     */
    @Column(name = "pwd_times")
    private Integer pwdTimes;

    /**
     * 会话过期时间-秒
     */
    @Column(name = "session_timeout")
    private Integer sessionTimeout;

    /**
     * 最大会话
     */
    @Column(name = "max_session")
    private Integer maxSession;

    /**
     * 登录失败次数限制
     */
    @Column(name = "fault_limit")
    private Integer faultLimit;

    /**
     * 锁定时间-秒
     */
    @Column(name = "lock_time")
    private Integer lockTime;

    /**
     * 账号扫描周期-秒
     */
    @Column(name = "scan_cycle")
    private Integer scanCycle;

    /**
     * 日志存量大小
     */
    @Column(name = "log_data_up")
    private Integer logDataUp;

    /**
     * 临时账号有效期-秒
     */
    @Column(name = "temp_account")
    private Integer tempAccount;

    /**
     * 账号进入休眠（账号未登录时间-秒）
     */
    @Column(name = "sleep_account")
    private Integer sleepAccount;

    /**
     * 允许访问时段-开始
     */
    @Column(name = "allow_access")
    private LocalDateTime allowAccess;

    /**
     * 允许访问时段-结束
     */
    @Column(name = "allow_not_access")
    private LocalDateTime allowNotAccess;

    /**
     * 登录网段：（*.*.*.0-255）星号代表0-255
     */
    @Column(name = "network_segment")
    private String networkSegment;

    /**
     * 是否有手动激活
     */
    @Column(name = "has_active")
    private Boolean hasActive;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time", updatable = false, nullable = false)
    private LocalDateTime createTime;

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
    private Boolean delFlag;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
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
