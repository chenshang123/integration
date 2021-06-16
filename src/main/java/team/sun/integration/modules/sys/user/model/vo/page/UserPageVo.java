package team.sun.integration.modules.sys.user.model.vo.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.org.model.entity.Org;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 系统-用户
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */
@ApiModel(value = "UserPageVo", description = "前端分页数据：查询")
public class UserPageVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /* 多对多：用户组-用户
    @ApiModelProperty(value = "用户组-用户")
    private Set<Group> groups = new HashSet<>();*/


    /* 多对多：用户-角色
    @ApiModelProperty(value = "用户-角色")
    private Set<Role> userRoles = new HashSet<>();*/

    /* 多对多：用户-单位（数据查看权限）
    @ApiModelProperty(value = "数据查看权限")
    private Set<Org> userDataNodes = new HashSet<>();*/


    /**
     * 一对一： 用户-单位 ：所属单位
     */
    @ApiModelProperty(value = "所属单位")
    private Org org;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String petName;

    /**
     * 登录用户名
     */
    @ApiModelProperty(value = "登录用户名")
    private String username;

    /**
     * 头像（人脸识别用）
     */
    @ApiModelProperty(value = "头像（人脸识别用）")
    private String faceImg;

    /**
     * 乖乖图
     */
    @ApiModelProperty(value = "乖乖图")
    private String petImg;

    /*
     * 密码
    @ApiModelProperty(value = "密码")
    private String pwd;*/

    /**
     * 盐值-用户创建、密码修改时创建
     */
    @ApiModelProperty(value = "盐值-用户创建、密码修改时创建")
    private String salt;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 性别 1:男 2:女 0:未知
     */
    @ApiModelProperty(value = "性别 1:男 2:女 0:未知")
    private Boolean gender;

    /**
     * 用户类型： 1：系统管理人员（在sys_org表中有归属） 2：外部人员
     */
    @ApiModelProperty(value = "用户类型： 1：系统管理人员（在sys_org表中有归属） 2：外部人员")
    private Integer userType;

    /**
     * 是否是初始用户 1：是 2：否
     */
    @ApiModelProperty(value = "是否是初始用户 1：是 2：否")
    private Boolean initType;

    /**
     * 用户状态 -1注销 0激活 1休眠 2未认证
     */
    @ApiModelProperty(value = "用户状态 -1注销 0激活 1休眠 2未认证 ")
    private Boolean state;

    /**
     * 修改密码时间
     */
    @ApiModelProperty(value = "修改密码时间")
    private LocalDateTime updatePwdTime;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime lastUpdateTime;

    /**
     * 休眠开始时间：只对处于休眠状态有效
     */
    @ApiModelProperty(value = "休眠开始时间：只对处于休眠状态有效")
    private LocalDateTime sleepTime;

    /**
     * 锁定时间
     */
    @ApiModelProperty(value = "锁定时间")
    private LocalDateTime lockTime;

    /**
     * 登录失败次数
     */
    @ApiModelProperty(value = "登录失败次数")
    private Integer loginFail;

    /**
     * 允许访问时间段
     */
    @ApiModelProperty(value = "允许访问时间段")
    private LocalDateTime allowAccess;

    /**
     * 允许访问时间段
     */
    @ApiModelProperty(value = "允许访问时间段")
    private LocalDateTime allowNotAccess;

    /**
     * 是否被锁定：0 未锁定 1锁定
     */
    @ApiModelProperty(value = "是否被锁定：0 未锁定 1锁定 ")
    private Boolean locked;

    /**
     * 单位类型
     */
    @ApiModelProperty(value = "单位类型")
    private Boolean unitType;

    /**
     * 数据权限类型（查询单位表，本级、本级及下级、自定义）
     */
    @ApiModelProperty(value = "数据权限类型（查询单位表，本级、本级及下级、自定义）")
    private Integer dataAuthorityType;

    /**
     * ic编号
     */
    @ApiModelProperty(value = "ic编号")
    private String icCard;

    /**
     * 固定ip (格式为*.*.*.* 星号只能是固定值0-255)
     */
    @ApiModelProperty(value = "固定ip (格式为*.*.*.* 星号只能是固定值0-255)")
    private String loginIp;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    /* 0正常 1删除
    @ApiModelProperty(value = "0正常 1删除")
    private Boolean delFlag;*/

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private Integer version;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", org=" + org +
                ", petName='" + petName + '\'' +
                ", username='" + username + '\'' +
                ", faceImg='" + faceImg + '\'' +
                ", petImg='" + petImg + '\'' +
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
                ", accessStart=" + allowAccess +
                ", allowNotAccess=" + allowNotAccess +
                ", locked=" + locked +
                ", unitType=" + unitType +
                ", dataAuthorityType=" + dataAuthorityType +
                ", icCard='" + icCard + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
