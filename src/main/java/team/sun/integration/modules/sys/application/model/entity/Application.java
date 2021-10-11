package team.sun.integration.modules.sys.application.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.application.model.enums.ApplicationAction;
import team.sun.integration.modules.sys.application.model.enums.ApplicationType;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.tenant.model.entity.TenantApplication;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-04
 */
@Entity
@Table(name = "sys_application")
@SQLDelete(sql = "update sys_application set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "Application-relation", attributeNodes = {
        @NamedAttributeNode("resources"),
        @NamedAttributeNode("tenantApplications"),
        @NamedAttributeNode("versions")
}))
public class Application implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "application_id")
    private String id;

    /**
     * 一对多：应用-菜单
     **/
    @OneToMany(mappedBy = "applicationResource", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Resource> resources = new HashSet<>();

    /**
     * 多对多转一对多：应用-租户
     */
    @OneToMany(mappedBy = "application", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<TenantApplication> tenantApplications = new HashSet<>();

    /**
     * 一对多：应用-应用版本
     **/
    @OneToMany(mappedBy = "applicationVer", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<ApplicationVersion> versions = new HashSet<>();

    /**
     * 标签
     */
    @Column(name = "label")
    private String label;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 访问地址
     */
    @Column(name = "access_url")
    private String accessUrl;

    /**
     * APPKEY
     */
    @Column(name = "appkey")
    private String appkey;

    /**
     * 简介
     */
    @Column(name = "introduce")
    private String introduce;

    /**
     * logo
     */
    @Column(name = "logo")
    private String logo;

    /**
     * 类型（电脑版网页、手机版网页、iosApp、安卓App）
     */
    @Convert(converter = ApplicationType.Convert.class)
    @Column(name = "type")
    private ApplicationType type;

    /**
     * 运行状态（运行中、停运中）
     */
    @Convert(converter = ApplicationAction.Convert.class)
    @Column(name = "run_state")
    private ApplicationAction runState;

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
    @JoinColumn(name = "creator_department_id", unique = true)
    private Org creatorDepartment;

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
        return "Application{" +
                "id='" + id + '\'' +
                ", resources=" + resources +
                ", tenantApplications=" + tenantApplications +
                ", versions=" + versions +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", accessUrl='" + accessUrl + '\'' +
                ", appkey='" + appkey + '\'' +
                ", introduce='" + introduce + '\'' +
                ", logo='" + logo + '\'' +
                ", type=" + type +
                ", runState=" + runState +
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

    public Set<TenantApplication> getTenantApplications() {
        return tenantApplications;
    }

    public void setTenantApplications(Set<TenantApplication> tenantApplications) {
        this.tenantApplications = tenantApplications;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Set<ApplicationVersion> getVersions() {
        return versions;
    }

    public void setVersions(Set<ApplicationVersion> versions) {
        this.versions = versions;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ApplicationType getType() {
        return type;
    }

    public void setType(ApplicationType type) {
        this.type = type;
    }

    public ApplicationAction getRunState() {
        return runState;
    }

    public void setRunState(ApplicationAction runState) {
        this.runState = runState;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Org getCreatorDepartment() {
        return creatorDepartment;
    }

    public void setCreatorDepartment(Org creatorDepartment) {
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
