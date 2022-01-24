package team.sun.integration.modules.detox.model.dto.save;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *戒毒人员体质测试
 */
@ApiModel(value = "JDRYTZCSJLBSaveDTO", description = "戒毒人员体质测试-详情")
public class JDRYTZCSJLBSaveDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    private String BH;

    @ApiModelProperty(value = "戒毒机构编码")
    private String JDJGBM;

    @ApiModelProperty(value = "戒毒人员编码")
    private String JDRYBM;

    @ApiModelProperty(value = "体质测试编号")
    private String TZCSBH;

    @ApiModelProperty(value = "专业人员编码")
    private String ZYRYBM;

    @ApiModelProperty(value = "测试开始时间")
    private LocalDateTime CSSJ;

    @ApiModelProperty(value = "测试结束时间")
    private LocalDateTime CSSJJS;

    @ApiModelProperty(value = "测试次数")
    private String numberRuns;

    @ApiModelProperty(value = "测试类别")
    private String CSLB;

    @ApiModelProperty(value = "测试项目")
    private String CSXM;

    @ApiModelProperty(value = "测试结果")
    private String CSJG;

    @ApiModelProperty(value = "测试评价")
    private String CSPJ;

    @ApiModelProperty(value = "是否达标")
    private String SFDB;

    @ApiModelProperty(value = "矫治意见")
    private String JZYJ;

    @ApiModelProperty(value = "测试警察")
    private String CSJC;

    @ApiModelProperty(value = "备注")
    private String BZ;

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

}
