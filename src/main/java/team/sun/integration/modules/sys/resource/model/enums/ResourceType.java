package team.sun.integration.modules.sys.resource.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import team.sun.integration.modules.base.enums.converter.BaseEnum;
import team.sun.integration.modules.base.enums.converter.BaseEnumConverter;

/**
 * 系统-菜单-码表：资源类型
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResourceType implements BaseEnum<Integer> {
    MENU(0, "菜单"),
    BUTTON(1, "按钮");

    private Integer value;
    private String desc;

    ResourceType(Integer value, String desc) {
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

    public static class Convert extends BaseEnumConverter<ResourceType, Integer> {

    }
}
