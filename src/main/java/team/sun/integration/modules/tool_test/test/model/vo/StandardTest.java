package team.sun.integration.modules.tool_test.test.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * 标准试验数据
 */
@ApiModel(value = "Standard-data", description = "工器具检测-标准试验数据对象")
public class StandardTest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "样品编号")
    private String code = "000004101200000311";
    @ApiModelProperty(value = "标准要求_额定电压（kV）")
    private String ratedVoltage = "10";
    @ApiModelProperty(value = "标准要求_交流耐压（kV）Alternating Current")
    private String ac = "20";
    @ApiModelProperty(value = "标准要求_持续时间（s）")
    private String times = "60";
    @ApiModelProperty(value = "标准要求_合格标准")
    private String standard = "无闪络、无过热";
    @ApiModelProperty(value = "检测情况_交流耐压（kV）")
    private String testAC = "0.0";
    @ApiModelProperty(value = "检测情况_检测情况_持续时间（s）")
    private String testTime = "0";
    @ApiModelProperty(value = "检测情况_样品状态")
    private String testSituation = "正常";
    @ApiModelProperty(value = "结论")
    private String testResult = "符合";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(String ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getTestAC() {
        return testAC;
    }

    public void setTestAC(String testAC) {
        this.testAC = testAC;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getTestSituation() {
        return testSituation;
    }

    public void setTestSituation(String testSituation) {
        this.testSituation = testSituation;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
