package team.sun.integration.modules.sys.user.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import team.sun.integration.modules.sys.group.model.entity.Group;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.position.model.entity.Position;
import team.sun.integration.modules.sys.role.model.entity.Role;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Set;


/**
 * <p>
 * 系统-用户
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */
@Entity
@Table(name = "sys_user")
@SQLDelete(sql = "update sys_user set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "User-relation", attributeNodes = {
        @NamedAttributeNode("groups"),
        @NamedAttributeNode("roles"),
        @NamedAttributeNode("positions"),
        @NamedAttributeNode("org")
}))
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "user_id")
    private String id;

    /**
     * 多对多：用户-用户组
     **/
    @ManyToMany(mappedBy = "users", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Group> groups;

    /**
     * 多对多：用户-角色
     **/
    @ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_user_role_mid",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonBackReference
    private Set<Role> roles;

    /**
     * 多对多：用户-职位
     **/
    @ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_user_position_mid",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    @JsonBackReference
    private Set<Position> positions;

    /**
     * 多对一： 用户-单位 ：所属单位
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", referencedColumnName = "org_id", nullable = false)
    @JsonBackReference
    private Org org;

    /**
     * 昵称
     */
    @Column(name = "pet_name")
    private String petName;

    /**
     * 登录用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 头像（人脸识别用）
     */
    @Column(name = "face_img")
    private String faceImg;

    /**
     * 乖乖图
     */
    @Column(name = "pet_img")
    private String petImg;

    /**
     * 密码
     */
    @Column(name = "pwd")
    @JSONField(serialize = false)
    private String pwd;

    /**
     * 盐值-用户创建、密码修改时创建
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 性别 1:男 2:女 0:未知
     */
    @Column(name = "gender")
    private Boolean gender;

    /**
     * 用户类型： 1：系统管理人员（在sys_org表中有归属） 2：外部人员
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 是否是初始用户 1：是 2：否
     */
    @Column(name = "init_type")
    private Boolean initType;

    /**
     * 用户状态 -1注销 0激活 1休眠 2未认证
     */
    @Column(name = "state")
    private Boolean state;

    /**
     * 修改密码时间
     */
    @Column(name = "update_pwd_time")
    private LocalDateTime updatePwdTime;

    /**
     * 最后修改时间
     */
    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    /**
     * 休眠开始时间：只对处于休眠状态有效
     */
    @Column(name = "sleep_time")
    private LocalDateTime sleepTime;

    /**
     * 锁定时间
     */
    @Column(name = "lock_time")
    private LocalDateTime lockTime;

    /**
     * 登录失败次数
     */
    @Column(name = "login_fail")
    private Integer loginFail;

    /**
     * 允许访问时间段
     */
    @Column(name = "allow_access")
    private LocalDateTime allowAccess;

    /**
     * 允许访问时间段
     */
    @Column(name = "allow_not_access")
    private LocalDateTime allowNotAccess;

    /**
     * 是否被锁定：0 未锁定 1锁定
     */
    @Column(name = "locked")
    private Boolean locked;

    /**
     * 单位类型
     */
    @Column(name = "unit_type")
    private Boolean unitType;

    /**
     * 数据权限类型（查询单位表，本级、本级及下级、自定义）
     */
    @Column(name = "data_authority_type")
    private Integer dataAuthorityType;

    /**
     * ic编号
     */
    @Column(name = "ic_card")
    private String icCard;

    /**
     * 固定ip (格式为*.*.*.* 星号只能是固定值0-255)
     */
    @Column(name = "login_ip")
    private String loginIp;

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
    private Character delFlag;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    private Integer version;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", petName='" + petName + '\'' +
                ", username='" + username + '\'' +
                ", faceImg='" + faceImg + '\'' +
                ", petImg='" + petImg + '\'' +
                ", pwd='" + pwd + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", userType=" + userType +
                ", initType=" + initType +
                ", state=" + state +
                ", updatePwdTime=" + updatePwdTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", sleepTime=" + sleepTime +
                ", lockTime=" + lockTime +
                ", loginFail=" + loginFail +
                ", allowAccess=" + allowAccess +
                ", allowNotAccess=" + allowNotAccess +
                ", locked=" + locked +
                ", unitType=" + unitType +
                ", dataAuthorityType=" + dataAuthorityType +
                ", icCard='" + icCard + '\'' +
                ", loginIp='" + loginIp + '\'' +
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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getPetImg() {
        return petImg;
    }

    public void setPetImg(String petImg) {
        this.petImg = petImg;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Boolean getInitType() {
        return initType;
    }

    public void setInitType(Boolean initType) {
        this.initType = initType;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public LocalDateTime getUpdatePwdTime() {
        return updatePwdTime;
    }

    public void setUpdatePwdTime(LocalDateTime updatePwdTime) {
        this.updatePwdTime = updatePwdTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public LocalDateTime getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(LocalDateTime sleepTime) {
        this.sleepTime = sleepTime;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    public Integer getLoginFail() {
        return loginFail;
    }

    public void setLoginFail(Integer loginFail) {
        this.loginFail = loginFail;
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

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getUnitType() {
        return unitType;
    }

    public void setUnitType(Boolean unitType) {
        this.unitType = unitType;
    }

    public Integer getDataAuthorityType() {
        return dataAuthorityType;
    }

    public void setDataAuthorityType(Integer dataAuthorityType) {
        this.dataAuthorityType = dataAuthorityType;
    }

    public String getIcCard() {
        return icCard;
    }

    public void setIcCard(String icCard) {
        this.icCard = icCard;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
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

    public Character getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Character delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
