package team.sun.integration.modules.detox.model.entity;

import com.google.common.base.Objects;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *戒毒人员训练记录
 */
@Entity
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "detox_training_record")
@SQLDelete(sql = "update detox_training_record set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class JDRYXLJLB implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JDRYXLJLB jdryxljlb)) return false;
        return Objects.equal(BH, jdryxljlb.BH) && Objects.equal(JDJGBM, jdryxljlb.JDJGBM) && Objects.equal(JDRYBM, jdryxljlb.JDRYBM) && Objects.equal(TZCSBH, jdryxljlb.TZCSBH) && Objects.equal(ZYRYBM, jdryxljlb.ZYRYBM) && Objects.equal(XLXM, jdryxljlb.XLXM) && Objects.equal(XLNR, jdryxljlb.XLNR) && Objects.equal(XLRQ, jdryxljlb.XLRQ) && Objects.equal(XLRQJS, jdryxljlb.XLRQJS) && Objects.equal(numberRuns, jdryxljlb.numberRuns) && Objects.equal(XLJG, jdryxljlb.XLJG) && Objects.equal(JZYJ, jdryxljlb.JZYJ) && Objects.equal(CSJC, jdryxljlb.CSJC) && Objects.equal(BZ, jdryxljlb.BZ) && Objects.equal(creatorDepartmentId, jdryxljlb.creatorDepartmentId) && Objects.equal(creatorId, jdryxljlb.creatorId) && Objects.equal(createTime, jdryxljlb.createTime) && Objects.equal(modifierId, jdryxljlb.modifierId) && Objects.equal(updateTime, jdryxljlb.updateTime) && Objects.equal(delFlag, jdryxljlb.delFlag) && Objects.equal(version, jdryxljlb.version);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(BH, JDJGBM, JDRYBM, TZCSBH, ZYRYBM, XLXM, XLNR, XLRQ, XLRQJS, numberRuns, XLJG, JZYJ, CSJC, BZ, creatorDepartmentId, creatorId, createTime, modifierId, updateTime, delFlag, version);
    }

    /** 编号*/
    @Id
    @GeneratedValue(generator = "detox_uuid")
    @GenericGenerator(name = "detox_uuid", strategy = "uuid")
    @Column(name = "training_record_id")
    private String BH;

    /** 戒毒机构编码*/
    @Column(name = "org_code")
    private String JDJGBM;

    /** 戒毒人员编码*/
    @Column(name = "person_code")
    private String JDRYBM;

    /** 训练记录编码*/
    @Column(name = "train_code")
    private String TZCSBH;

    /** 专业人员编码*/
    @Column(name = "professional_code")
    private String ZYRYBM;

    /** 训练项目*/
    @Column(name = "train_project")
    private String XLXM;

    /** 训练内容*/
    @Column(name = "train_content")
    private String XLNR;

    /** 训练日期*/
    @Column(name = "train_time_start")
    private LocalDateTime XLRQ;

    /** 训练日期*/
    @Column(name = "train_time_end")
    private LocalDateTime XLRQJS;

    /** 训练次数*/
    @Column(name = "number_runs")
    private String numberRuns;

    /** 训练结果*/
    @Column(name = "train_result")
    private String XLJG;

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

    public String getXLXM() {
        return XLXM;
    }

    public void setXLXM(String XLXM) {
        this.XLXM = XLXM;
    }

    public String getXLNR() {
        return XLNR;
    }

    public void setXLNR(String XLNR) {
        this.XLNR = XLNR;
    }

    public LocalDateTime getXLRQ() {
        return XLRQ;
    }

    public void setXLRQ(LocalDateTime XLRQ) {
        this.XLRQ = XLRQ;
    }

    public LocalDateTime getXLRQJS() {
        return XLRQJS;
    }

    public void setXLRQJS(LocalDateTime XLRQJS) {
        this.XLRQJS = XLRQJS;
    }

    public String getNumberRuns() {
        return numberRuns;
    }

    public void setNumberRuns(String numberRuns) {
        this.numberRuns = numberRuns;
    }

    public String getXLJG() {
        return XLJG;
    }

    public void setXLJG(String XLJG) {
        this.XLJG = XLJG;
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

    public void setDelFlag(Boolean delFlag) { this.delFlag = delFlag; }

    public Integer getVersion() { return version; }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
