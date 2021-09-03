package team.sun.integration.modules.sys.permission.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.role.model.entity.Role;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-权限表
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@Table(name = "sys_permission_data")
@SQLDelete(sql = "update sys_permission_data set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class PermissionData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;
    /**
     * 菜单
     */

    private String resourceId;

    /**
     * 应用
     */
    private String applicationId;

    /**
     * 租户
     */
    private String tenantId;

    /**
     * 基础数据权限、数据权限共享
     */

    @Column(name = "type")
    private Integer type;

    /**
     * 私有、公开只读、公开读写
     */
    @Column(name = "permission_type")
    private Integer permissionType;

    /**
     * 数据来源-用户
     */
    private String sourceUserId;

    /**
     * 数据来源-用户组
     */
    private String sourceGroupId;

    /**
     * 数据来源-部门
     */
    private String sourceDepartmentId;

    /**
     * 共享数据-用户
     */
    private String shareUserId;

    /**
     * 共享数据-用户组
     */
    private String shareGroupId;

    /**
     * 共享数据-部门
     */
    private String shareDepartmentId;

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

}
