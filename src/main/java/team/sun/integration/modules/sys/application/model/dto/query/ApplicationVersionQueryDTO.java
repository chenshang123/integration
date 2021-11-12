package team.sun.integration.modules.sys.application.model.dto.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 系统-应用版本
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */

@ApiModel(value = "ApplicationVersionQueryDTO", description = "系统-应用版本-查询")
public class ApplicationVersionQueryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "应用")
    private String application_id;

    @ApiModelProperty(value = "应用版本号")
    private String applicationVersion;

    @ApiModelProperty(value = "版本说明")
    private String explain;

    @ApiModelProperty(value = "上线（是、否）")
    private Integer online;

    @ApiModelProperty(value = "安装包地址")
    private String installPackage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getInstallPackage() {
        return installPackage;
    }

    public void setInstallPackage(String installPackage) {
        this.installPackage = installPackage;
    }

}