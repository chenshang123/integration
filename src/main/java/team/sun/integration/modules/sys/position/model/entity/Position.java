package team.sun.integration.modules.sys.position.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
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
    @Column(name = "position_id")
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
     * 一对一： 创建人所属部门
     */
    @Column(name = "creator_department_id")
    private String creatorDepartmentId;

    /**
     * 一对一： 创建人所属租户
     */
    @Column(name = "creator_tenant_Id")
    private String creatorTenantId;

    /**
     * 一对一： 创建人
     */
    @CreatedBy
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time", updatable = false, nullable = false)
    private LocalDateTime createTime;

    /**
     * 一对一： 最后修改人
     */
    @LastModifiedBy
    @Column(name = "modifier_id")
    private String modifierId;

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
    private Character delFlag;

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
                ", creatorDepartmentId='" + creatorDepartmentId + '\'' +
                ", creatorTenantId='" + creatorTenantId + '\'' +
                ", creatorId='" + creatorId + '\'' +
                ", createTime=" + createTime +
                ", modifierId='" + modifierId + '\'' +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                ", version=" + version +
                '}';
    }


}
