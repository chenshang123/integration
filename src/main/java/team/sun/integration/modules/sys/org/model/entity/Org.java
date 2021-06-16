package team.sun.integration.modules.sys.org.model.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import team.sun.integration.modules.sys.group.model.entity.Group;
import team.sun.integration.modules.sys.user.model.entity.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * 系统-单位/组织/机构
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@Table(name = "sys_org")
@SQLDelete(sql = "update sys_org set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class Org implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /**
     * 多对多：用户-单位（数据查看权限）
     **/
    @ManyToMany(mappedBy = "userDataNodes", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    /**
     * 多对多：用户组-单位（数据查看权限）
     **/
    @ManyToMany(mappedBy = "groupDataNodes", cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Group> groups = new HashSet<>();

    /**
     * 首层id
     */
    @Column(name = "first_floor_id")
    private String firstFloorId;

    /**
     * 父类id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 层级
     */
    @Column(name = "layer")
    private Integer layer;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 隐藏编号（id1_id2_id3_...当前层级以上节点id）
     */
    @Column(name = "hidden_code")
    private String hiddenCode;

    /**
     * 行政级别划分（1.总称 2.省级 3.自治区 4.市级 5.区级 6.县级 ）
     */
    @Column(name = "administrative_type")
    private Integer administrativeType;

    /**
     * 单位划分 （单位 部门 工区  班  组）
     */
    @Column(name = "unit_type")
    private Integer unitType;

    /**
     * 数据节点-关联系统（用户关联数据节点）
     */
    @Column(name = "relation_sys")
    private Boolean relationSys;

    /**
     * 单位名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 字符编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 相关说明
     */
    @Column(name = "profile")
    private String profile;

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
        return "Org{" +
                "id='" + id + '\'' +
                //", users=" + users +
                //", groups=" + groups +
                ", firstFloorId='" + firstFloorId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", layer=" + layer +
                ", sort=" + sort +
                ", hiddenCode='" + hiddenCode + '\'' +
                ", administrativeType=" + administrativeType +
                ", unitType=" + unitType +
                ", relationSys=" + relationSys +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", profile='" + profile + '\'' +
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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
