package team.sun.integration.modules.sys.resource.model.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import team.sun.integration.modules.sys.permission.model.entity.Permission;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <p>
 * 系统-菜单：
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@Table(name = "sys_resource")
@SQLDelete(sql = "update sys_resource set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /**
     * 多对多：权限-资源（菜单）
     **/
    @ManyToMany(mappedBy = "permissionResources", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Permission> permissions = new HashSet<>();


    /**
     * 首层id
     */
    @Column(name = "first_floor_id")
    private String firstFloorId;

    /**
     * 父级菜单id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 层级
     */
    @Column(name = "layer")
    private Integer layer;

    /**
     * 顺序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 隐藏编号（id1_id2_id3_...当前层级以上节点id）
     */
    @Column(name = "hidden_code")
    private String hiddenCode;

    /**
     * 菜单名称(英文)
     */
    @Column(name = "name")
    private String name;

    /**
     * 显示名称(中文)
     */
    @Column(name = "title")
    private String title;

    /**
     * 权限代码
     */
    @Column(name = "permission")
    private String permission;

    /**
     * 前端路径
     */
    @Column(name = "path")
    private String path;

    /**
     * 前端组件路径
     */
    @Column(name = "component")
    private String component;

    /**
     * 类型（电脑版网页、手机版网页、iosApp、安卓App、）
     */
    @Column(name = "type")
    private Integer type;

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
        return "Resource{" +
                "id='" + id + '\'' +
                ", permissions=" + permissions +
                ", firstFloorId='" + firstFloorId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", layer=" + layer +
                ", sort=" + sort +
                ", hiddenCode='" + hiddenCode + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", permission='" + permission + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", type=" + type +
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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
