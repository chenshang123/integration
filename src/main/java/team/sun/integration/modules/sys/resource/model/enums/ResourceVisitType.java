package team.sun.integration.modules.sys.resource.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import team.sun.integration.config.base.enums.converter.BaseEnum;
import team.sun.integration.config.base.enums.converter.BaseEnumConverter;

/**
 * 系统-菜单-码表：请求方式
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResourceVisitType implements BaseEnum<Integer> {
    GET(0, "get"),
    POST(1, "post"),
    PUT(2, "put");

    private Integer value;
    private String desc;

    ResourceVisitType(Integer value, String desc) {
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

    public static class Convert extends BaseEnumConverter<ResourceVisitType, Integer> {

    }
}
