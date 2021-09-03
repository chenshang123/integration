package team.sun.integration.modules.sys.tenant.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.application.model.entity.Application;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 中间表：租户-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-23
 */

@Entity
@Table(name = "sys_tenant_application_mid")
@SQLDelete(sql = "update sys_tenant_application_mid set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "TenantApplication-relation", attributeNodes = {
        @NamedAttributeNode("tenant"),
        @NamedAttributeNode("application")
}))
public class TenantApplication implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;

    /**
     * 多对多转多对一：租户-应用
     **/
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.DETACH},fetch=FetchType.LAZY)
    @JoinColumn(name="tenant_id",referencedColumnName="id")
    @JsonBackReference
    private Tenant tenant;


    /**
     * 多对多转多对一：租户-应用
     **/
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.DETACH},fetch=FetchType.LAZY)
    @JoinColumn(name="application_id",referencedColumnName="id")
    @JsonBackReference
    private Application application;

    /**
     * 可用天数
     */
    private Integer days;

    /**
     * 使用状态（永久可用、使用中、已到期、已禁用）
     */
    private Integer state;

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
