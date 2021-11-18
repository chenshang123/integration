package team.sun.integration.modules.sys.application.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import team.sun.integration.modules.base.enums.converter.BaseEnum;
import team.sun.integration.modules.base.enums.converter.BaseEnumConverter;

/**
 * 系统-应用：应用类型
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApplicationType implements BaseEnum<Integer> {
    SYSTEM(0, "管理系统"),
    WEBSITE(1, "门户网站"),
    ANDROID(2, "Android-APP"),
    APPLE(3, "Apple-APP"),
    APPLET(4, "WeChat-小程序"),
    SUBSCRIPTION(5, "WeChat-公众号");

    private Integer value;
    private String desc;

    ApplicationType(Integer value, String desc) {
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

    public static class Convert extends BaseEnumConverter<ApplicationType, Integer> {

    }
}
