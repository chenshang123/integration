package team.sun.integration.modules.sys.tenant.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import team.sun.integration.common.base.enums.converter.BaseEnum;
import team.sun.integration.common.base.enums.converter.BaseEnumConverter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TenantApplicationAction implements BaseEnum<Integer> {
    PERMANENTLY(0, "永久可用"),
    USED(1, "使用中"),
    EXPIRED(2, "已到期"),
    DISABLED(3, "已禁用");
    private Integer value;
    private String desc;

    TenantApplicationAction(Integer value, String desc) {
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

    public static class Convert extends BaseEnumConverter<TenantApplicationAction, Integer> {

    }
}
