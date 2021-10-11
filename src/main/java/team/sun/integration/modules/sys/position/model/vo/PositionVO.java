package team.sun.integration.modules.sys.position.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.org.model.vo.OrgVO;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;
import team.sun.integration.modules.sys.user.model.vo.UserVO;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-职位：详情
 * </p>
 *
 * @author auto generator
 * @since 2021-08-05
 */

@ApiModel(value = "PositionPageVO", description = "系统-职位：详情")
public class PositionVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "多对多：职位-用户")
    private Set<UserVO> users = new HashSet<>();

    @ApiModelProperty(value = "职位名称")
    private String name;

    @ApiModelProperty(value = "说明")
    private String explain;

    @ApiModelProperty(value = "一对一： 创建人")
    private UserVO creator;

    @ApiModelProperty(value = "一对一： 创建人所属部门")
    private OrgVO creatorDepartment;

    @ApiModelProperty(value = "一对一： 创建人所属租户")
    private TenantVO creatorTenant;

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
        return "Position{" +
                "id='" + id + '\'' +
                ", users=" + users +
                ", name='" + name + '\'' +
                ", explain='" + explain + '\'' +
                ", creator=" + creator +
                ", creatorDepartment=" + creatorDepartment +
                ", creatorTenant=" + creatorTenant +
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

    public Set<UserVO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserVO> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public UserVO getCreator() {
        return creator;
    }

    public void setCreator(UserVO creator) {
        this.creator = creator;
    }

    public OrgVO getCreatorDepartment() {
        return creatorDepartment;
    }

    public void setCreatorDepartment(OrgVO creatorDepartment) {
        this.creatorDepartment = creatorDepartment;
    }

    public TenantVO getCreatorTenant() {
        return creatorTenant;
    }

    public void setCreatorTenant(TenantVO creatorTenant) {
        this.creatorTenant = creatorTenant;
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
