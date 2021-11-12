package team.sun.integration.modules.sys.role.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.group.model.vo.GroupVO;
import team.sun.integration.modules.sys.org.model.vo.OrgVO;
import team.sun.integration.modules.sys.resource.model.vo.ElementVO;
import team.sun.integration.modules.sys.resource.model.vo.ResourceVO;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;
import team.sun.integration.modules.sys.user.model.vo.UserVO;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-角色：详情
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@ApiModel(value = "RoleVO", description = "系统-角色：详情")
public class RoleVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "多对多：角色-菜单")
    private Set<ResourceVO> resources = new HashSet<>();

    @ApiModelProperty(value = "多对多：角色-菜单页面元素")
    private Set<ElementVO> elements = new HashSet<>();

    @ApiModelProperty(value = "多对多：角色-用户")
    private Set<UserVO> users = new HashSet<>();

    @ApiModelProperty(value = "多对多：角色-用户组")
    private Set<GroupVO> groups = new HashSet<>();

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "是否可用：0不可用 1可用")
    private Boolean available;

    @ApiModelProperty(value = "备注说明")
    private String remarks;

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

    public RoleVO() {
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "id='" + id + '\'' +
                ", resources=" + resources +
                ", elements=" + elements +
                ", users=" + users +
                ", groups=" + groups +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", remarks='" + remarks + '\'' +
                ", creatorDepartmentId='" + creatorDepartmentId + '\'' +
                ", creatorTenantId='" + creatorTenantId + '\'' +
                ", creatorId='" + creatorId + '\'' +
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

    public Set<ResourceVO> getResources() {
        return resources;
    }

    public void setResources(Set<ResourceVO> resources) {
        this.resources = resources;
    }

    public Set<ElementVO> getElements() {
        return elements;
    }

    public void setElements(Set<ElementVO> elements) {
        this.elements = elements;
    }

    public Set<UserVO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserVO> users) {
        this.users = users;
    }

    public Set<GroupVO> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupVO> groups) {
        this.groups = groups;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
