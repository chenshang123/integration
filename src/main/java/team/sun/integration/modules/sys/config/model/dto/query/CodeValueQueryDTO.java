package team.sun.integration.modules.sys.config.model.dto.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统-码值
 * </p>
 *
 * @author auto generator
 * @since 2021-03-03
 */

@ApiModel(value = "CodeValue对象", description = "系统-码值")
public class CodeValueQueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "value")
    private String name;

    @ApiModelProperty(value = "父类id")
    private String parentId;

    @ApiModelProperty(value = "视图名称")
    private String viewName;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}