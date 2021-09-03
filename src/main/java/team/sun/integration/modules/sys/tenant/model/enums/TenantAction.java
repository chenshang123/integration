package team.sun.integration.modules.sys.tenant.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import team.sun.integration.config.base.enums.converter.BaseEnum;
import team.sun.integration.config.base.enums.converter.BaseEnumConverter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TenantAction implements BaseEnum<Integer> {
    LOCKED(0, "锁定中"),
    USING(1, "使用中");

    private Integer value;
    private String desc;

    TenantAction(Integer value, String desc) {
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

    public static class Convert extends BaseEnumConverter<TenantAction, Integer> {

    }
}
