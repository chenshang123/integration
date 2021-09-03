package team.sun.integration.modules.tool_test.contract.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.tool_test.tool.model.entity.ToolClassify;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 合同-单项明细-工器具
 * </p>
 *
 * @author auto generator
 * @since 2021-08-13
*/

@Entity
@Table(name = "test_contract_item_tool")
@SQLDelete(sql = "update test_contract_item_tool set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class ContractItemTool implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;

    /**
     * 多对一：合同
    */
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.DETACH},fetch= FetchType.LAZY)
    @JoinColumn(name="contract_id",referencedColumnName="id")
    @JsonBackReference
    private Contract toolItemContract;

    /**
     * 工器具分类
    */
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "tool_classify_id", unique = true)
    private ToolClassify toolClassify;

    /**
     * 总额
    */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 数量
    */
    @Column(name = "number")
    private Integer number;

    /**
     * 状态
    */
    @Column(name = "state")
    private Integer state;

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
    @JoinColumn(name = "department_id", unique = true)
    private Org department;

    /**
     * 一对一： 创建人所属租户
     */
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", unique = true)
    private Tenant tenant;

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
        return "ContractItemTool{" +
                "id='" + id + '\'' +
                ", toolItemContract=" + toolItemContract +
                ", toolClassify=" + toolClassify +
                ", totalAmount='" + totalAmount + '\'' +
                ", number=" + number +
                ", state=" + state +
                ", creator=" + creator +
                ", department=" + department +
                ", tenant=" + tenant +
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

    public Contract getToolItemContract() {
        return toolItemContract;
    }

    public void setToolItemContract(Contract toolItemContract) {
        this.toolItemContract = toolItemContract;
    }

    public ToolClassify getToolClassify() {
        return toolClassify;
    }

    public void setToolClassify(ToolClassify toolClassify) {
        this.toolClassify = toolClassify;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Org getDepartment() {
        return department;
    }

    public void setDepartment(Org department) {
        this.department = department;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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
