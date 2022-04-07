package team.sun.integration.modules.sys.table.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import team.sun.integration.common.base.enums.converter.BaseEnum;
import team.sun.integration.common.base.enums.converter.BaseEnumConverter;

/**
 * 表-关系：表关联关系
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TableRelationType implements BaseEnum<String> {
    OTO("oto", "一对一"),
    MTO("mto", "多对一"),
    OTM("otm", "一对多"),
    MTM("mtm", "多对多");

    private String value;
    private String desc;

    TableRelationType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static class Convert extends BaseEnumConverter<TableRelationType, String> {

    }
}
