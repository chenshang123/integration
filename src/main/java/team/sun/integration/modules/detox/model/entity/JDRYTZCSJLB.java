package team.sun.integration.modules.detox.model.entity;

import com.google.common.base.Objects;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *戒毒人员体质测试
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "detox_physical_fitness_test")
@SQLDelete(sql = "update detox_physical_fitness_test set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class JDRYTZCSJLB implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JDRYTZCSJLB)) return false;
        JDRYTZCSJLB that = (JDRYTZCSJLB) o;
        return Objects.equal(BH, that.BH) && Objects.equal(JDJGBM, that.JDJGBM) && Objects.equal(JDRYBM, that.JDRYBM) && Objects.equal(TZCSBH, that.TZCSBH) && Objects.equal(ZYRYBM, that.ZYRYBM) && Objects.equal(CSSJ, that.CSSJ) && Objects.equal(CSSJJS, that.CSSJJS) && Objects.equal(numberRuns, that.numberRuns) && Objects.equal(CSLB, that.CSLB) && Objects.equal(CSXM, that.CSXM) && Objects.equal(CSJG, that.CSJG) && Objects.equal(CSPJ, that.CSPJ) && Objects.equal(SFDB, that.SFDB) && Objects.equal(JZYJ, that.JZYJ) && Objects.equal(CSJC, that.CSJC) && Objects.equal(BZ, that.BZ) && Objects.equal(creatorDepartmentId, that.creatorDepartmentId) && Objects.equal(creatorId, that.creatorId) && Objects.equal(createTime, that.createTime) && Objects.equal(modifierId, that.modifierId) && Objects.equal(updateTime, that.updateTime) && Objects.equal(delFlag, that.delFlag) && Objects.equal(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(BH, JDJGBM, JDRYBM, TZCSBH, ZYRYBM, CSSJ, CSSJJS, numberRuns, CSLB, CSXM, CSJG, CSPJ, SFDB, JZYJ, CSJC, BZ, creatorDepartmentId, creatorId, createTime, modifierId, updateTime, delFlag, version);
    }

    /** 编号*/
    @Id
    @GeneratedValue(generator = "detox_uuid")
    @GenericGenerator(name = "detox_uuid", strategy = "uuid")
    @Column(name = "physical_fitness_test_id")
    private String BH;

    /** 戒毒机构编码*/
    @Column(name = "org_code")
    private String JDJGBM;

    /** 戒毒人员编码*/
    @Column(name = "person_code")
    private String JDRYBM;

    /** 体质测试编号*/
    @Column(name = "test_code")
    private String TZCSBH;

    /** 专业人员编码*/
    @Column(name = "professional_code")
    private String ZYRYBM;

    /** 测试开始时间*/
    @Column(name = "test_time_start")
    private LocalDateTime CSSJ;

    /** 测试结束时间*/
    @Column(name = "test_time_end")
    private LocalDateTime CSSJJS;

    /** 测试次数*/
    @Column(name = "number_runs")
    private String numberRuns;

    /** 测试类别*/
    @Column(name = "test_type")
    private String CSLB;

    /** 测试项目*/
    @Column(name = "test_project")
    private String CSXM;

    /** 测试结果*/
    @Column(name = "test_result")
    private String CSJG;

    /** 测试评价*/
    @Column(name = "test_evaluate")
    private String CSPJ;

    /** 是否达标*/
    @Column(name = "up_to_standard")
    private String SFDB;

    /** 矫治意见*/
    @Column(name = "opinion")
    private String JZYJ;

    /** 测试警察*/
    @Column(name = "officer")
    private String CSJC;

    /** 备注*/
    @Column(name = "remarks")
    private String BZ;

    /**
     * 一对一： 创建人所属部门
     */
    @Column(name = "creator_department_id")
    private String creatorDepartmentId;

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
    private Boolean delFlag = false;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    private Integer version;

    public String getBH() {
        return BH;
    }

    public void setBH(String BH) {
        this.BH = BH;
    }

    public String getJDJGBM() {
        return JDJGBM;
    }

    public void setJDJGBM(String JDJGBM) {
        this.JDJGBM = JDJGBM;
    }

    public String getJDRYBM() {
        return JDRYBM;
    }

    public void setJDRYBM(String JDRYBM) {
        this.JDRYBM = JDRYBM;
    }

    public String getTZCSBH() {
        return TZCSBH;
    }

    public void setTZCSBH(String TZCSBH) {
        this.TZCSBH = TZCSBH;
    }

    public String getZYRYBM() {
        return ZYRYBM;
    }

    public void setZYRYBM(String ZYRYBM) {
        this.ZYRYBM = ZYRYBM;
    }

    public LocalDateTime getCSSJ() {
        return CSSJ;
    }

    public void setCSSJ(LocalDateTime CSSJ) {
        this.CSSJ = CSSJ;
    }

    public LocalDateTime getCSSJJS() {
        return CSSJJS;
    }

    public void setCSSJJS(LocalDateTime CSSJJS) {
        this.CSSJJS = CSSJJS;
    }

    public String getNumberRuns() {
        return numberRuns;
    }

    public void setNumberRuns(String numberRuns) {
        this.numberRuns = numberRuns;
    }

    public String getCSLB() {
        return CSLB;
    }

    public void setCSLB(String CSLB) {
        this.CSLB = CSLB;
    }

    public String getCSXM() {
        return CSXM;
    }

    public void setCSXM(String CSXM) {
        this.CSXM = CSXM;
    }

    public String getCSJG() {
        return CSJG;
    }

    public void setCSJG(String CSJG) {
        this.CSJG = CSJG;
    }

    public String getCSPJ() {
        return CSPJ;
    }

    public void setCSPJ(String CSPJ) {
        this.CSPJ = CSPJ;
    }

    public String getSFDB() {
        return SFDB;
    }

    public void setSFDB(String SFDB) {
        this.SFDB = SFDB;
    }

    public String getJZYJ() {
        return JZYJ;
    }

    public void setJZYJ(String JZYJ) {
        this.JZYJ = JZYJ;
    }

    public String getCSJC() {
        return CSJC;
    }

    public void setCSJC(String CSJC) {
        this.CSJC = CSJC;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    public String getCreatorDepartmentId() {
        return creatorDepartmentId;
    }

    public void setCreatorDepartmentId(String creatorDepartmentId) {
        this.creatorDepartmentId = creatorDepartmentId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
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
