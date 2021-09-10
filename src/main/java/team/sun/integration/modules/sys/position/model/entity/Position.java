package team.sun.integration.modules.sys.position.model.entity;

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
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-职位
 * </p>
 *
 * @author auto generator
 * @since 2021-08-05
 */
@Entity
@Table(name = "sys_position")
@SQLDelete(sql = "update sys_position set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "Position-relation", attributeNodes = {
        @NamedAttributeNode("positionUsers")
}))
public class Position implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;

    /**
     * 多对多：职位-用户
     **/
    @ManyToMany(mappedBy = "userPositions", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<User> positionUsers = new HashSet<>();

    /**
     * 职位名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 说明
     */
    @Column(name = "explain")
    private String explain;

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
    @JoinColumn(name = "department_id", unique = true)
    private Org department;

    /**
     * 一对一： 创建人所属租户
     */
    @OneToOne(cascade = CascadeType.DETACH, optional = false, fetch = FetchType.LAZY)
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
        return "Position{" +
                "id='" + id + '\'' +
                ", positionUsers=" + positionUsers +
                ", name='" + name + '\'' +
                ", explain='" + explain + '\'' +
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

    public Set<User> getPositionUsers() {
        return positionUsers;
    }

    public void setPositionUsers(Set<User> positionUsers) {
        this.positionUsers = positionUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
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
