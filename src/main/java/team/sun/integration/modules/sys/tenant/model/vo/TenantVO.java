package team.sun.integration.modules.sys.tenant.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.resource.model.entity.Element;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.tenant.model.entity.TenantApplication;
import team.sun.integration.modules.sys.tenant.model.enums.TenantAction;
import team.sun.integration.modules.sys.user.model.entity.User;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-租户：详情
 * </p>
 *
 * @author auto generator
 * @since 2021-08-04
 */

@ApiModel(value="TenantPageVO", description="系统-租户：详情")
public class TenantVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "多对多：租户-菜单")
    private Set<Resource> tenantResources = new HashSet<>();

    @ApiModelProperty(value = "多对多：租户-菜单页面元素")
    private Set<Element> tenantElements = new HashSet<>();

    @ApiModelProperty(value = "多对多转一对多：租户-应用")
    private Set<TenantApplication> tenantApplications = new HashSet<>();

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "账户")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "盐值-用户创建、密码修改时创建")
    private String salt;

    @ApiModelProperty(value = "所属行业")
    private String industry;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "联系电话")
    private String contactTelephone;

    @ApiModelProperty(value = "邮箱")
    private String mail;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "县")
    private String county;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "是否被锁定：0 未锁定 1锁定")
    private TenantAction locked;

    @ApiModelProperty(value = "一对一： 创建人")
    private User creator;

    @ApiModelProperty(value = "一对一： 创建人所属部门")
    private Org department;

    @ApiModelProperty(value = "一对一： 创建人所属租户")
    private TenantVO tenant;

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

    public TenantVO getTenant() {
        return tenant;
    }

    public void setTenant(TenantVO tenant) {
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
