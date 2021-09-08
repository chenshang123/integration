package team.sun.integration.modules.sys.tenant.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.resource.model.entity.Element;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.tenant.model.enums.TenantAction;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-租户
 * </p>
 *
 * @author auto generator
 * @since 2021-08-04
 */
@Entity
@Table(name = "sys_tenant")
@SQLDelete(sql = "update sys_tenant set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "Tenant-relation", attributeNodes = {
        @NamedAttributeNode("tenantResources"),
        @NamedAttributeNode("tenantElements"),
        @NamedAttributeNode("tenantApplications")
}))
public class Tenant implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;

    /**
     * 多对多：租户-菜单
     */
    @ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_tenant_resource_mid",
            joinColumns = @JoinColumn(name = "tenant_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private Set<Resource> tenantResources = new HashSet<>();
    /**
     * 多对多：租户-菜单页面元素
     */
    @ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_tenant_element_mid",
            joinColumns = @JoinColumn(name = "tenant_id"),
            inverseJoinColumns = @JoinColumn(name = "element_id")
    )
    private Set<Element> tenantElements = new HashSet<>();

    /**
     * 多对多转一对多：租户-应用
     */
    @OneToMany(mappedBy = "tenant", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<TenantApplication> tenantApplications = new HashSet<>();

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 账户
     */
    @Column(name = "account")
    private String account;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 盐值-用户创建、密码修改时创建
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 所属行业
     */
    @Column(name = "industry")
    private String industry;

    /**
     * 联系人
     */
    @Column(name = "contacts")
    private String contacts;

    /**
     * 联系电话
     */
    @Column(name = "contact_telephone")
    private String contactTelephone;

    /**
     * 邮箱
     */
    @Column(name = "mail")
    private String mail;

    /**
     * 省
     */
    @Column(name = "province")
    private String province;

    /**
     * 市
     */
    @Column(name = "city")
    private String city;

    /**
     * 县
     */
    @Column(name = "county")
    private String county;

    /**
     * 详细地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 是否被锁定：0 未锁定 1锁定
     */
    @Convert(converter = TenantAction.Convert.class)
    @Column(name = "locked")
    private TenantAction locked;

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
        return "Tenant{" +
                "id='" + id + '\'' +
                ", tenantResources=" + tenantResources +
                ", tenantElements=" + tenantElements +
                ", tenantApplications=" + tenantApplications +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", industry='" + industry + '\'' +
                ", contacts='" + contacts + '\'' +
                ", contactTelephone='" + contactTelephone + '\'' +
                ", mail='" + mail + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", address='" + address + '\'' +
                ", locked=" + locked +
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

    public Set<TenantApplication> getTenantApplications() {
        return tenantApplications;
    }

    public void setTenantApplications(Set<TenantApplication> tenantApplications) {
        this.tenantApplications = tenantApplications;
    }

    public Set<Resource> getTenantResources() {
        return tenantResources;
    }

    public void setTenantResources(Set<Resource> tenantResources) {
        this.tenantResources = tenantResources;
    }

    public Set<Element> getTenantElements() {
        return tenantElements;
    }

    public void setTenantElements(Set<Element> tenantElements) {
        this.tenantElements = tenantElements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TenantAction getLocked() {
        return locked;
    }

    public void setLocked(TenantAction locked) {
        this.locked = locked;
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
