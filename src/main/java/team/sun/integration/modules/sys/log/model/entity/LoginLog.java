package team.sun.integration.modules.sys.log.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 系统-登录日志
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@Table(name = "sys_log_login")
@SQLDelete(sql = "update sys_log_login set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class LoginLog implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;

    /**
     * 管理菜单页面id
     */
    private String resourceId;

    /**
     * ip
     */
    private String ip;

    /**
     * 操作名称
     */
    private String name;

    /**
     * 入参内容
     */
    private String parameter;

    /**
     * 操作内容
     */
    private String content;

    /**
     * 操作状态 0失败 1成功
     */
    private Boolean state;

    /**
     * 日志类型： 0 系统日志 1业务日志  2 异常事件
     */
    private Integer type;

    /**
     * 一对一： 创建人
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", unique = true)
    private User creator;
    /**
     * 一对一： 创建人所属部门
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", unique = true)
    private Org department;

    /**
     * 一对一： 创建人所属租户
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", unique = true)
    private Tenant tenant;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @LastModifiedDate
    @Column(nullable = false)
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

    @Override
    public String toString() {
        return "LoginLog{" +
                "id='" + id + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", parameter='" + parameter + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", creator=" + creator +
                ", department=" + department +
                ", tenant=" + tenant +
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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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
