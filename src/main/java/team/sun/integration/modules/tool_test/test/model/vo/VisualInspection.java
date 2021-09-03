package team.sun.integration.modules.tool_test.test.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * 外观检测
 */
@ApiModel(value="VisualInspection-data", description="工器具检测-外观检测对象")
public class VisualInspection implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "样品编号")
    private String code = "000004101200000311";

    @ApiModelProperty(value = "标准要求")
    private String standard = "无破损,无弯折";

    @ApiModelProperty(value = "检测情况")
    private String situation = "正常";

    @ApiModelProperty(value = "结论")
    private String conclusion = "合格";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
