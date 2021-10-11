package team.sun.integration.modules.sys.file.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.tool_test.contract.model.entity.Contract;

import javax.persistence.*;
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

@Entity
@Table(name = "sys_file")
@SQLDelete(sql = "update sys_file set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class FileEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "file_id")
    private String id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", referencedColumnName = "contract_id")
    @JsonBackReference
    private Contract contractFile;

    /**
     * 文件类型
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 文件大小
     */
    @Column(name = "size")
    private Integer size;

    /**
     * 文件名
     */
    @Column(name = "name")
    private String name;

    /**
     * 存储地址
     */
    @Column(name = "storage_url")
    private String storageUrl;

    /**
     * 业务名称
     */
    @Column(name = "business_name")
    private String businessName;

    /**
     * 业务id
     */
    @Column(name = "business_id")
    private String businessId;

    /**
     * 一对一： 创建人
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", unique = true)
    private User creator;

    /**
     * 一对一： 创建人所属部门
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_department_id", unique = true)
    private Org creatorDepartment;

    /**
     * 一对一： 创建人所属租户
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
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
        return "File{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", size='" + size + '\'' +
                ", name='" + name + '\'' +
                ", storageUrl='" + storageUrl + '\'' +
                ", businessName='" + businessName + '\'' +
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

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
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
