package team.sun.integration.modules.sys.application.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.application.model.enums.ApplicationAction;
import team.sun.integration.modules.sys.application.model.enums.ApplicationType;
import team.sun.integration.modules.sys.resource.model.vo.ResourceVO;
import team.sun.integration.modules.sys.tenant.model.vo.TenantApplicationVO;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */

@ApiModel(value = "ApplicationVO", description = "系统-应用-详情")
public class ApplicationVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "一对多：应用-菜单")
    private Set<ResourceVO> resources;

    @ApiModelProperty(value = "多对多转一对多：应用-租户")
    private Set<TenantApplicationVO> tenantApplications;

    @ApiModelProperty(value = "一对多：应用-应用版本")
    private Set<ApplicationVersionVO> applicationVersions;

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

    @ApiModelProperty(value = "运行状态（运行中、停运中）")
    private ApplicationAction runState;

    @ApiModelProperty(value = "0正常 1删除")
    private Boolean delFlag;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @Override
    public String toString() {
        return "ApplicationVO{" +
                "id='" + id + '\'' +
                ", resources=" + resources +
                ", tenantApplications=" + tenantApplications +
                ", applicationVersions=" + applicationVersions +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", accessUrl='" + accessUrl + '\'' +
                ", appkey='" + appkey + '\'' +
                ", introduce='" + introduce + '\'' +
                ", logo='" + logo + '\'' +
                ", type=" + type +
                ", runState=" + runState +
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

    public Set<TenantApplicationVO> getTenantApplications() {
        return tenantApplications;
    }

    public void setTenantApplications(Set<TenantApplicationVO> tenantApplications) {
        this.tenantApplications = tenantApplications;
    }

    public Set<ApplicationVersionVO> getApplicationVersions() {
        return applicationVersions;
    }

    public void setApplicationVersions(Set<ApplicationVersionVO> applicationVersions) {
        this.applicationVersions = applicationVersions;
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

    public ApplicationAction getRunState() {
        return runState;
    }

    public void setRunState(ApplicationAction runState) {
        this.runState = runState;
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