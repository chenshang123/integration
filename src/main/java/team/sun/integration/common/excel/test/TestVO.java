package team.sun.integration.common.excel.test;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import team.sun.integration.common.excel.annotation.ExcelColumnName;
import team.sun.integration.common.utils.FileExcel;

import io.swagger.annotations.ApiModelProperty;


/**
 * 导出VO
 *
 * @version 1.0.0
 * @ClassName: TestVO
 * @Description: 导出   字段加上注解 @ExcelColumnName  表示要导出此字段，导出字段顺序 从上往下排列
 * @author: liudebing
 * @date: 2020年4月22日 上午10:48:33
 */
public class TestVO implements Serializable {
    private static final long serialVersionUID = -2049688626357047360L;
    @ApiModelProperty(value = "设备编号")
    private String equipCode;
    @ApiModelProperty(value = "设备类型名称")
    @ExcelColumnName("设备类型")
    private String typeName;
    @ApiModelProperty(value = "设备信号(dbm)")
    private Integer deviceSignal;
    @ApiModelProperty(value = "设备信号名称")
    @ExcelColumnName("设备信号")
    private String deviceSignalName;

    public static void main(String[] args) {
        List<TestVO> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            TestVO vo = new TestVO();
            vo.setEquipCode("设备编号：" + i);
            vo.setTypeName("设备类型：" + i);
            vo.setDeviceSignal(i);
            vo.setDeviceSignalName("设备信号" + i);
            list.add(vo);
        }
        FileExcel<TestVO> we = new FileExcel<TestVO>();
        try {
            we.writeExcel(list, "sheet名称", new File("D:/a.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(String equipCode) {
        this.equipCode = equipCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getDeviceSignal() {
        return deviceSignal;
    }

    public void setDeviceSignal(Integer deviceSignal) {
        this.deviceSignal = deviceSignal;
    }

    public String getDeviceSignalName() {
        return deviceSignalName;
    }

    public void setDeviceSignalName(String deviceSignalName) {
        this.deviceSignalName = deviceSignalName;
    }
}
