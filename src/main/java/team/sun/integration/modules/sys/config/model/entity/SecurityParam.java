package team.sun.integration.modules.sys.config.model.entity;

import java.io.Serial;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
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
     * 一对一： 创建人所属部门
     */
    @Column(name = "creator_department_id")
    private String creatorDepartmentId;

    /**
     * 一对一： 创建人所属租户
     */
    @Column(name = "creator_tenant_Id")
    private String creatorTenantId;

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
        return "SecurityParam{" +
                "id='" + id + '\'' +
                ", pwdTimes=" + pwdTimes +
                ", sessionTimeout=" + sessionTimeout +
                ", maxSession=" + maxSession +
                ", faultLimit=" + faultLimit +
                ", lockTime=" + lockTime +
                ", scanCycle=" + scanCycle +
                ", logDataUp=" + logDataUp +
                ", tempAccount=" + tempAccount +
                ", sleepAccount=" + sleepAccount +
                ", allowAccess=" + allowAccess +
                ", allowNotAccess=" + allowNotAccess +
                ", networkSegment='" + networkSegment + '\'' +
                ", hasActive=" + hasActive +
                ", creatorDepartmentId='" + creatorDepartmentId + '\'' +
                ", creatorTenantId='" + creatorTenantId + '\'' +
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

    public Boolean getDelFlag() { return delFlag; }

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
