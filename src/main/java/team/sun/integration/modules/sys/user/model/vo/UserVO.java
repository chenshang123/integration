package team.sun.integration.modules.sys.user.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.group.model.vo.GroupVO;
import team.sun.integration.modules.sys.org.model.vo.OrgVO;
import team.sun.integration.modules.sys.position.model.vo.PositionVO;
import team.sun.integration.modules.sys.role.model.vo.RoleVO;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-用户
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */
@ApiModel(value = "UserVo", description = "前端详情数据")
public class UserVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "用户组-用户")
    private Set<GroupVO> groups = new HashSet<>();

    @ApiModelProperty(value = "用户-角色")
    private Set<RoleVO> userRoles = new HashSet<>();

    @ApiModelProperty(value = "用户-职位")
    private Set<PositionVO> positions = new HashSet<>();

    @ApiModelProperty(value = "一对一： 用户-单位 ：所属单位")
    private OrgVO org;

    @ApiModelProperty(value = "昵称")
    private String petName;

    @ApiModelProperty(value = "登录用户名")
    private String username;

    @ApiModelProperty(value = "头像（人脸识别用）")
    private String faceImg;

    @ApiModelProperty(value = "乖乖图")
    private String petImg;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "盐值-用户创建、密码修改时创建")
    private String salt;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "性别 1:男 2:女 0:未知")
    private Boolean gender;

    @ApiModelProperty(value = "用户类型： 1：系统管理人员（在sys_org表中有归属） 2：外部人员")
    private Integer userType;

    @ApiModelProperty(value = "是否是初始用户 1：是 2：否")
    private Boolean initType;

    @ApiModelProperty(value = "用户状态 -1注销 0激活 1休眠 2未认证")
    private Boolean state;

    @ApiModelProperty(value = "修改密码时间")
    private LocalDateTime updatePwdTime;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime lastUpdateTime;

    @ApiModelProperty(value = "休眠开始时间：只对处于休眠状态有效")
    private LocalDateTime sleepTime;

    @ApiModelProperty(value = "锁定时间")
    private LocalDateTime lockTime;

    @ApiModelProperty(value = "登录失败次数")
    private Integer loginFail;

    @ApiModelProperty(value = "允许访问时间段")
    private LocalDateTime allowAccess;

    @ApiModelProperty(value = "允许访问时间段")
    private LocalDateTime allowNotAccess;

    @ApiModelProperty(value = "是否被锁定：0 未锁定 1锁定")
    private Boolean locked;

    @ApiModelProperty(value = "单位类型")
    private Boolean unitType;

    @ApiModelProperty(value = "数据权限类型（查询单位表，本级、本级及下级、自定义）")
    private Integer dataAuthorityType;

    @ApiModelProperty(value = "ic编号")
    private String icCard;

    @ApiModelProperty(value = "固定ip (格式为*.*.*.* 星号只能是固定值0-255)")
    private String loginIp;

    @ApiModelProperty(value = "创建人所属部门")
    private String creatorDepartmentId;

    @ApiModelProperty(value = "创建人所属租户")
    private String creatorTenantId;

    @ApiModelProperty(value = "创建人")
    private String creatorId;

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

    public Set<GroupVO> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupVO> groups) {
        this.groups = groups;
    }

    public Set<RoleVO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<RoleVO> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<PositionVO> getPositions() {
        return positions;
    }

    public void setPositions(Set<PositionVO> positions) {
        this.positions = positions;
    }

    public OrgVO getOrg() {
        return org;
    }

    public void setOrg(OrgVO org) {
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
