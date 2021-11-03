package team.sun.integration.modules.sys.file.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import team.sun.integration.modules.sys.org.model.vo.OrgVO;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;
import team.sun.integration.modules.sys.user.model.vo.UserVO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统-文件
 * </p>
 *
 * @author auto generator
 * @since 2021-08-13
 */

@ApiModel(value = "FileEntityPageVO", description = "系统-文件-分页")
public class FileVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;

    @ApiModelProperty(value = "文件类型")
    private Integer type;

    @ApiModelProperty(value = "文件大小")
    private Integer size;

    @ApiModelProperty(value = "文件名")
    private String name;

    @ApiModelProperty(value = "存储地址")
    private String storageUrl;

    @ApiModelProperty(value = "业务名称")
    private String businessName;

    @ApiModelProperty(value = "菜单id")
    private String resourceId;

    @ApiModelProperty(value = "0正常 1删除")
    private Boolean delFlag;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", size='" + size + '\'' +
                ", name='" + name + '\'' +
                ", storageUrl='" + storageUrl + '\'' +
                ", businessName='" + businessName + '\'' +
                ", resourceId='" + resourceId + '\'' +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStorageUrl() {
        return storageUrl;
    }

    public void setStorageUrl(String storageUrl) {
        this.storageUrl = storageUrl;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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
