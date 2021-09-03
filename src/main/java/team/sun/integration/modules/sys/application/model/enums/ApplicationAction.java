package team.sun.integration.modules.sys.application.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import team.sun.integration.config.base.enums.converter.BaseEnum;
import team.sun.integration.config.base.enums.converter.BaseEnumConverter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApplicationAction implements BaseEnum<Integer> {
    REG(0, "运营中"),
    RESET(1, "停运中"),
    LOGIN(2, "未上线"),
    LOGOUT(3, "维护中");

    private Integer value;
    private String desc;

    ApplicationAction(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static class Convert extends BaseEnumConverter<ApplicationAction, Integer> {

    }
}
