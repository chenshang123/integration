package team.sun.integration.modules.sys.application.model.dto.save;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.application.model.enums.ApplicationType;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */

@ApiModel(value = "ApplicationSave对象", description = "系统-应用-保存")
public class ApplicationSaveDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "应用")
    private String applicationId;

    @ApiModelProperty(value = "标签")
    private String label;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "访问地址")
    private String accessUrl;

    @ApiModelProperty(value = "APPKEY")
    private String appkey;

    @ApiModelProperty(value = "简介")
    private String introduce;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "类型（电脑版网页、手机版网页、iosApp、安卓App）")
    private ApplicationType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ApplicationType getType() {
        return type;
    }

    public void setType(ApplicationType type) {
        this.type = type;
    }

}