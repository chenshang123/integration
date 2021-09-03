package team.sun.integration.modules.sys.org.model.dto.update;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统-单位/组织/机构
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@ApiModel(value = "Org对象", description = "系统-单位/组织/机构")
public class OrgUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "首层id")
    private String firstFloorId;

    @ApiModelProperty(value = "父类id")
    private String parentId;

    @ApiModelProperty(value = "层级")
    private Integer layer;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "隐藏编号（id1_id2_id3_...当前层级以上节点id）")
    private String hiddenCode;

    @ApiModelProperty(value = "行政级别划分（1.总称 2.省级 3.自治区 4.市级 5.区级 6.县级 ）")
    private Integer administrativeType;

    @ApiModelProperty(value = "单位划分 （单位 部门 工区  班  组）")
    private Integer unitType;

    @ApiModelProperty(value = "数据节点-关联系统（用户关联数据节点）")
    private Boolean relationSys;

    @ApiModelProperty(value = "单位名称")
    private String name;

    @ApiModelProperty(value = "字符编码")
    private String code;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "相关说明")
    private String explain;

    @ApiModelProperty(value = "创建人")
    private String creatorId;

    @ApiModelProperty(value = "所属部门")
    private String departmentId;

    @ApiModelProperty(value = "所属租户")
    private String tenantId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

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

    public String getFirstFloorId() {
        return firstFloorId;
    }

    public void setFirstFloorId(String firstFloorId) {
        this.firstFloorId = firstFloorId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getHiddenCode() {
        return hiddenCode;
    }

    public void setHiddenCode(String hiddenCode) {
        this.hiddenCode = hiddenCode;
    }

    public Integer getAdministrativeType() {
        return administrativeType;
    }

    public void setAdministrativeType(Integer administrativeType) {
        this.administrativeType = administrativeType;
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    public Boolean getRelationSys() {
        return relationSys;
    }

    public void setRelationSys(Boolean relationSys) {
        this.relationSys = relationSys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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