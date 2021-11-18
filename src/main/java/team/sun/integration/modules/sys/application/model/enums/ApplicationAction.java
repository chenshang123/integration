package team.sun.integration.modules.sys.application.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import team.sun.integration.modules.base.enums.converter.BaseEnum;
import team.sun.integration.modules.base.enums.converter.BaseEnumConverter;
/**
 * 系统-应用：应用运营状态
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApplicationAction implements BaseEnum<Integer> {
    OPEN(0, "运营中"),
    SHUTDOWN(1, "停运中"),
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
