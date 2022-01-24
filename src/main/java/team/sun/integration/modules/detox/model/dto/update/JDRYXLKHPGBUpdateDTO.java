package team.sun.integration.modules.detox.model.dto.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *戒毒人员员训练考核评估
 */
@ApiModel(value = "JDRYXLKHPGBUpdateDTO", description = "戒毒人员员训练考核评估-详情")
public class JDRYXLKHPGBUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    private String BH;

    @ApiModelProperty(value = "戒毒机构编码")
    private String JDJGBM;

    @ApiModelProperty(value = "戒毒人员编码")
    private String JDRYBM;

    @ApiModelProperty(value = "评估内容")
    private String PGNR;

    @ApiModelProperty(value = "评估日期")
    private LocalDateTime PGRQ;

    @ApiModelProperty(value = "评估日期")
    private LocalDateTime PGRQJS;

    @ApiModelProperty(value = "评估测试次数")
    private String numberRuns;

    @ApiModelProperty(value = "评估结果")
    private String PGJG;

    @ApiModelProperty(value = "矫治意见")
    private String JZYJ;

    @ApiModelProperty(value = "测试警察")
    private String CSJC;

    @ApiModelProperty(value = "备注")
    private String BZ;

    @ApiModelProperty(value = "版本号")
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

    public Integer getVersion() { return version; }

    public void setVersion(Integer version) { this.version = version; }
}
