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
 *戒毒人员员训练考核评估
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "detox_training_assess")
@SQLDelete(sql = "update detox_training_assess set del_flag = true where training_assess_id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class JDRYXLKHPGB implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /** 编号*/
    @Id
    @GeneratedValue(generator = "detox_uuid")
    @GenericGenerator(name = "detox_uuid", strategy = "uuid")
    @Column(name = "training_assess_id")
    private String BH;

    /** 戒毒机构编码*/
    @Column(name = "org_code")
    private String JDJGBM;

    /** 戒毒人员编码*/
    @Column(name = "person_code")
    private String JDRYBM;

    /** 评估内容*/
    @Column(name = "assess_content")
    private String PGNR;

    /** 评估日期*/
    @Column(name = "assess_time_start")
    private LocalDateTime PGRQ;

    /** 评估日期*/
    @Column(name = "assess_time_end")
    private LocalDateTime PGRQJS;

    /** 评估测试次数*/
    @Column(name = "number_runs")
    private String numberRuns;

    /** 评估结果*/
    @Column(name = "assess_result")
    private String PGJG;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JDRYXLKHPGB)) return false;
        JDRYXLKHPGB that = (JDRYXLKHPGB) o;
        return Objects.equal(BH, that.BH) && Objects.equal(JDJGBM, that.JDJGBM) && Objects.equal(JDRYBM, that.JDRYBM) && Objects.equal(PGNR, that.PGNR) && Objects.equal(PGRQ, that.PGRQ) && Objects.equal(PGRQJS, that.PGRQJS) && Objects.equal(numberRuns, that.numberRuns) && Objects.equal(PGJG, that.PGJG) && Objects.equal(JZYJ, that.JZYJ) && Objects.equal(CSJC, that.CSJC) && Objects.equal(BZ, that.BZ) && Objects.equal(creatorDepartmentId, that.creatorDepartmentId) && Objects.equal(creatorId, that.creatorId) && Objects.equal(createTime, that.createTime) && Objects.equal(modifierId, that.modifierId) && Objects.equal(updateTime, that.updateTime) && Objects.equal(delFlag, that.delFlag) && Objects.equal(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(BH, JDJGBM, JDRYBM, PGNR, PGRQ, PGRQJS, numberRuns, PGJG, JZYJ, CSJC, BZ, creatorDepartmentId, creatorId, createTime, modifierId, updateTime, delFlag, version);
    }

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

    public String getPGNR() {
        return PGNR;
    }

    public void setPGNR(String PGNR) {
        this.PGNR = PGNR;
    }

    public LocalDateTime getPGRQ() {
        return PGRQ;
    }

    public void setPGRQ(LocalDateTime PGRQ) {
        this.PGRQ = PGRQ;
    }

    public LocalDateTime getPGRQJS() {
        return PGRQJS;
    }

    public void setPGRQJS(LocalDateTime PGRQJS) {
        this.PGRQJS = PGRQJS;
    }

    public String getNumberRuns() {
        return numberRuns;
    }

    public void setNumberRuns(String numberRuns) {
        this.numberRuns = numberRuns;
    }

    public String getPGJG() {
        return PGJG;
    }

    public void setPGJG(String PGJG) {
        this.PGJG = PGJG;
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
