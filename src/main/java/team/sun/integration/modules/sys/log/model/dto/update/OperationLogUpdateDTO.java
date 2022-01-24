package team.sun.integration.modules.sys.log.model.dto.update;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 系统-操作日志：	1.日志包含时间、地点（方法）、人物	2.还原操作，记录参数、影响内容
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@ApiModel(value = "OperationLogUpdate对象", description = "系统-操作日志-修改")
public class OperationLogUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "管理菜单页面id")
    private String resourceId;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "操作名称")
    private String name;

    @ApiModelProperty(value = "入参内容")
    private String parameter;

    @ApiModelProperty(value = "操作内容")
    private String content;

    @ApiModelProperty(value = "操作状态 0失败 1成功")
    private Boolean state;

    @ApiModelProperty(value = "日志类型： 0 系统日志 1业务日志  2 异常事件")
    private Integer type;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}