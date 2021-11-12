package team.sun.integration.modules.sys.resource.model.dto.update;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 系统-菜单元素
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@ApiModel(value = "ElementUpdate对象", description = "系统-菜单元素：修改")
public class ElementUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "管理菜单页面id")
    private String fkResourceId;

    @ApiModelProperty(value = "页面元素名称")
    private String elementName;

    @ApiModelProperty(value = "页面元素标识")
    private String elementIdentify;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkResourceId() {
        return fkResourceId;
    }

    public void setFkResourceId(String fkResourceId) {
        this.fkResourceId = fkResourceId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementIdentify() {
        return elementIdentify;
    }

    public void setElementIdentify(String elementIdentify) {
        this.elementIdentify = elementIdentify;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}