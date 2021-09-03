package team.sun.integration.modules.tool_test.test.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@ApiModel(value="ToolTest-data", description="工器具检测-数据对象")
public class ToolTestDataVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工器具名称")
    private String name = "绝缘手套";

    @ApiModelProperty(value = "工器具型号")
    private String model = "10kV";

    @ApiModelProperty(value = "样品编号")
    private String code = "000004101200000311";

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "生产日期")
    private String productionDate;

    @ApiModelProperty(value = "试验性质")
    private String nature = "预防性试验";

    @ApiModelProperty(value = "本次试验日期")
    private String testDate = "2021-07-14";

    @ApiModelProperty(value = "下次试验日期")
    private String nextTestDate = "2022-01-13";

    @ApiModelProperty(value = "试验周期")
    private String testCycle = "6(月)";

    @ApiModelProperty(value = "室温")
    private String roomTemp = "℃";

    @ApiModelProperty(value = "湿度")
    private String humidity = "%RH";

    @ApiModelProperty(value = "外观检测")
    private List<VisualInspection> visualInspections;

    @ApiModelProperty(value = "标准试验数据")
    private List<StandardTest> standardTests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getNextTestDate() {
        return nextTestDate;
    }

    public void setNextTestDate(String nextTestDate) {
        this.nextTestDate = nextTestDate;
    }

    public String getTestCycle() {
        return testCycle;
    }

    public void setTestCycle(String testCycle) {
        this.testCycle = testCycle;
    }

    public String getRoomTemp() {
        return roomTemp;
    }

    public void setRoomTemp(String roomTemp) {
        this.roomTemp = roomTemp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public List<VisualInspection> getVisualInspections() {
        return visualInspections;
    }

    public void setVisualInspections(List<VisualInspection> visualInspections) {
        this.visualInspections = visualInspections;
    }

    public List<StandardTest> getStandardTests() {
        return standardTests;
    }

    public void setStandardTests(List<StandardTest> standardTests) {
        this.standardTests = standardTests;
    }
}
