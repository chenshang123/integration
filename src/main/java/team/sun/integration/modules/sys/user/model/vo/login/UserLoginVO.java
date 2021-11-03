package team.sun.integration.modules.sys.user.model.vo.login;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色
 */
public class UserLoginVO implements Serializable {

    private String id;

    /**用户-角色*/
    private List<String> roleIds = new ArrayList<>();

    /**登录用户名*/
    private String username;

    /**密码*/
    private String pwd;

    /**盐值-用户创建、密码修改时创建*/
    private String salt;

    /**电话*/
    private String phone;

    /**性别 1:男 2:女 0:未知*/
    private Boolean gender;

    /**用户类型： 1：系统管理人员（在sys_org表中有归属） 2：外部人员*/
    private Integer userType;

    /**是否是初始用户 1：是 2：否*/
    private Boolean initType;

    /**用户状态 -1注销 0激活 1休眠 2未认证*/
    private Boolean state;

    /**登录失败次数*/
    private Integer loginFail;

    /**允许访问时间段*/
    private LocalDateTime allowAccess;

    /**允许访问时间段*/
    private LocalDateTime allowNotAccess;

    /**是否被锁定：0 未锁定 1锁定*/
    private Boolean locked;

    /**单位类型*/
    private Boolean unitType;

    /**数据权限类型（查询单位表，本级、本级及下级、自定义）*/
    private Integer dataAuthorityType;

    /**固定ip (格式为*.*.*.* 星号只能是固定值0-255)*/
    private String loginIp;

    /**0正常 1删除*/
    private Boolean delFlag;

    /**版本号*/
    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
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
