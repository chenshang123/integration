package team.sun.integration.modules.tool_test.tool.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 工器具-分类
 * </p>
 *
 * @author auto generator
 * @since 2021-08-13
 */

@Entity
@Table(name = "tool_classify")
@SQLDelete(sql = "update tool_classify set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class ToolClassify implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "tool_classify_id")
    private String id;

    /**
     * 第一层级id
     */
    @Column(name = "first_floor_Id")
    private String firstFloorId;

    /**
     * 父级id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 所属层级编号
     */
    @Column(name = "layer")
    private Integer layer;

    /**
     * 隐藏编号（id1_id2_id3_...当前层级以上节点id）
     */
    @Column(name = "hidden_code")
    private String hiddenCode;

    /**
     * 本层级顺序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 编号
     */
    @Column(name = "code")
    private String code;

    /**
     * 规格型号
     */
    @Column(name = "model")
    private String model;

    /**
     * 电压等级
     */
    @Column(name = "volt")
    private Integer volt;

    /**
     * 一对一： 创建人
     */
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", unique = true)
    private User creator;

    /**
     * 一对一： 创建人所属部门
     */
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_department_id", unique = true)
    private Org creatorDepartment;

    /**
     * 一对一： 创建人所属租户
     */
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_tenant_id", unique = true)
    private Tenant creatorTenant;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time", updatable = false, nullable = false)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;

    /**
     * 0正常 1删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    private Integer version;

    @Override
    public String toString() {
        return "ToolClassify{" +
                "id='" + id + '\'' +
                ", firstFloorId='" + firstFloorId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", layer=" + layer +
                ", hiddenCode='" + hiddenCode + '\'' +
                ", sort=" + sort +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", model='" + model + '\'' +
                ", volt=" + volt +
                ", creator=" + creator +
                ", creatorDepartment=" + creatorDepartment +
                ", creatorTenant=" + creatorTenant +
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

    public String getHiddenCode() {
        return hiddenCode;
    }

    public void setHiddenCode(String hiddenCode) {
        this.hiddenCode = hiddenCode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getVolt() {
        return volt;
    }

    public void setVolt(Integer volt) {
        this.volt = volt;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

        public Org getCreatorDepartment() {
        return creatorDepartment;
    }

    public void setCreatorDepartment(Org creatorDepartment) {
        this.creatorDepartment = creatorDepartment;
    }

    public Tenant getCreatorTenant() {
        return creatorTenant;
    }

    public void setCreatorTenant(Tenant creatorTenant) {
        this.creatorTenant = creatorTenant;
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
