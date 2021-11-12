package team.sun.integration.modules.sys.group.model.dto.save;


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
public class GroupSaveDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分组名称")
    private String name;

    @ApiModelProperty(value = "相关说明")
    private String explain;

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

}