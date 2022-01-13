package team.sun.integration.common.base.enums.ret;

/**
 * 常用错误码
 * 0 成功dao
 * 大于0 不同dao的值专来表示不同的错误原因
 * 小于0 一般只用 -1，表示异属常
 *
 * @author chens
 */
public enum SysRetEnum implements BaseKeyValue<String, String> {

    /**
     * ************************系统异常编号**********************************************
     */
    SYS_ERROR_CONNECT_SERVER("10018", "连接服务器失败"),
    //网关异常
    /**
     * -1<br/>系统异常
     ***/
    SYS_ERROR("-1", "系统异常"),
    /**
     * 10001<br/>系统繁忙,请稍候再试
     ***/
    SYS_BUSY("-10001", "系统繁忙,请稍候再试"),
    /**
     * 10503<br/>服务不可用
     ***/
    SYS_GATEWAY_NOT_FOUND_SERVICE("-10503", "服务不可用"),
    /**
     * 10500<br/>网关异常
     ***/
    SYS_GATEWAY_ERROR("-10500", "网关异常"),
    SYS_GATEWAY_PREDICATES_PARAM_ERROR("-10901", "网关断言格式错误"),
    SYS_GATEWAY_PREDICATES_EMPTY("-10902", "网关断言参数值不能为空"),
    SYS_GATEWAY_FILTER_PARAM_ERROR("-10903", "过滤规则格式错误"),
    SYS_GATEWAY_FILTER_EMPTY("-10904", "过滤规则参数值不能为空"),
    SYS_GATEWAY_PREDICATES_NO_PARAM("-10905", "网关断言参数错误"),
    SYS_GATEWAY_FILTER_NO_PARAM("-10906", "过滤规则参数错误"),
    /**
     * 10408<br/>网关超时
     ***/
    SYS_GATEWAY_CONNECT_TIME_OUT("-10408", "网关超时"),
    /**
     * 10500<br/>服务器异常
     ***/
    SYS_INTERNAL_SERVER_ERROR("-10500", "服务器异常"),
    /**
     * 数据未找到或已删除
     **/
    SYS_NOT_FOUND_DATA("-10414", "数据未找到或已删除");

    private String key;

    private String value;

    private SysRetEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }
}