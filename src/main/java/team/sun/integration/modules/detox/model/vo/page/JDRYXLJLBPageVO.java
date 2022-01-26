package team.sun.integration.modules.detox.model.vo.page;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *戒毒人员训练记录
 */
public class JDRYXLJLBPageVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    private String BH;

    @ApiModelProperty(value = "戒毒机构编码")
    private String JDJGBM;

    @ApiModelProperty(value = "戒毒人员编码")
    private String JDRYBM;

    @ApiModelProperty(value = "训练记录编码")
    private String TZCSBH;

    @ApiModelProperty(value = "专业人员编码")
    private String ZYRYBM;

    @ApiModelProperty(value = "训练项目")
    private String XLXM;

    @ApiModelProperty(value = "训练内容")
    private String XLNR;

    @ApiModelProperty(value = "训练日期")
    private LocalDateTime XLRQ;

    @ApiModelProperty(value = "训练日期")
    private LocalDate XLRQJS;

    @ApiModelProperty(value = "训练次数")
    private String numberRuns;

    @ApiModelProperty(value = "训练结果")
    private String XLJG;

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

    public LocalDate getXLRQJS() {
        return XLRQJS;
    }

    public void setXLRQJS(LocalDate XLRQJS) {
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

    public Integer getVersion() { return version; }

    public void setVersion(Integer version) { this.version = version; }
}
