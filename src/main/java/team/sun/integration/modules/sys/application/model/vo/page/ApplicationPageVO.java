package team.sun.integration.modules.sys.application.model.vo.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import team.sun.integration.modules.sys.application.model.enums.ApplicationAction;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-04
 */

@ApiModel(value = "ApplicationPageVO", description = "系统-应用-分页")
public class ApplicationPageVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

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
    private Integer type;

    @ApiModelProperty(value = "运行状态（运行中、停运中）")
    private ApplicationAction runState;

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
        return "Application{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", accessUrl='" + accessUrl + '\'' +
                ", appkey='" + appkey + '\'' +
                ", introduce='" + introduce + '\'' +
                ", logo='" + logo + '\'' +
                ", type=" + type +
                ", runState=" + runState +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ApplicationAction getRunState() {
        return runState;
    }

    public void setRunState(ApplicationAction runState) {
        this.runState = runState;
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
