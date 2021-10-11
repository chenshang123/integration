package team.sun.integration.config.base.enums.ret;

/**
 * 常用错误码
 * 0 成功dao
 * 大于0 不同dao的值专来表示不同的错误原因
 * 小于0 一般只用 -1，表示异属常
 *
 * @author chens
 */
public enum BusRetEnum implements BaseKeyValue<String, String> {


    /* 操作成功 */
    SUCCESS("0", "操作成功"),
    FAIL("1", "操作失败"),
    UNDEFINED_EXCEPTION("2", "未知错误"),
    BUS_NULL_POINTER("3", "空指针异常"),
    /**
     * ************************业务异常编号 10022**********************************************
     */
    /* 命名规则：模块名称_错误类型（参数param、查询sel、文件file）_内容简写 */

    /* 参数param 10100*/
    BUS_PARAM_VERIFICATION_FAIL("10100", "参数校验失败"),
    BUS_PARAM_IS_NULL("10100", "参数不能为空"),
    /* 查询sel 10200*/
    BUS_SEl_REMOVE_PRAM_IS_ERROR("10200", "未查询到需要删除的数据"),
    BUS_SEl_DETAIL_IS_NULL("10201", "详情为空"),
    BUS_SEl_MULTIPLE_RECORDS("10202", "记录有多条"),
    BUS_SEl_RECORD_ALREADY_EXISTS("10203", "记录已经存在"),
    /* 文件file 10300*/
    BUS_FILE_UPLOAD_ERROR("10300", "文件上传错误"),
    BUS_FILE_DOWNLOAD_ERROR("10301", "文件下载错误"),
    BUS_FILE_NOT_EXIST("10302", "上传文件为空"),
    BUS_FILE_TYPE_NOT_SUPPORTED("10303", "文件类型不支持"),
    BUS_File_EXCEL_CASE_ERROR("10304", "excel 转换错误"),
    BUS_FILE_PATH_ERROR("10305", "文件存储路径错误"),
    BUS_FILE_UPLOAD_SUCCESS("10306", "文件上传成功"),
    BUS_FILE_SINGLE_OVERRUN("10307", "单个文件超出最大值"),
    BUS_FILE_OVERRUN("10308", "上传文件的总大小超出限制的最大值"),
    BUS_FILE_EXT_NAME_ERROR("10309", "文件扩展名错误"),

    /* 登录login 10400*/
    BUS_LOGIN_BAD_CREDENTIALS("10400", "用户校验失败，请检查用户名与密码！"),
    BUS_LOGIN_TIMEOUT("10401", "登录超时，请重新登录！"),
    BUS_LOGIN_EXPIRES("10402", "登录过期，请重新登录！"),
    BUS_LOGIN_NOT_LOGGED_IN("10404", "未登录，请登录！"),
    BUS_LOGIN_CREATE_TOKEN_FAIL("10405", "创建token失败，请与管理员联系！"),
    /* 设备device 10500*/
    BUS_DEVICE_STATE_NOT_ALLOW("10500", "设备状态不允许该操作"),
    /* 权限验证 10600*/
    BUS_PERMISSION_INADEQUATE("10600", "权限不足！"),
    BUS_PERMISSION_TOKEN_INVALID("10405", "token失效，请重新登录！");
    private final String key;

    private final String value;

    BusRetEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getMsg(){
        return "Error code:"+ key +",tips:"+value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}