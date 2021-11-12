package team.sun.integration.modules.sys.group.model.dto.update;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 系统-用户组：	组具有自己的角色信息、权限信息
 * </p>
 *
 * @author auto generator
 * @since 2021-02-01
 */

@ApiModel(value = "Group对象", description = "系统-用户组：	组具有自己的角色信息、权限信息")
public class GroupUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "分组名称")
    private String name;

    @ApiModelProperty(value = "相关说明")
    private String explain;

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