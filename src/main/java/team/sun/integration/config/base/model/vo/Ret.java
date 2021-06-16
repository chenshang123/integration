package team.sun.integration.config.base.model.vo;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import team.sun.integration.config.base.enums.ret.BaseKeyValue;
import team.sun.integration.config.base.enums.ret.BusRetEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;


/**
 * 返回对象Result封装
 *
 * @author chens
 */
@Api("返回结果")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Ret<T> implements Serializable {
    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码")
    private String code;

    /**
     * 提示消息
     */
    @ApiModelProperty("提示消息")
    private String msg;

    /**
     * 数据对象
     */
    @ApiModelProperty("数据对象")
    private T data;

    public Ret(BaseKeyValue<String, String> enumData) {
        this.code = enumData.getKey();
        this.msg = enumData.getValue();
    }

    public Ret(T data, BaseKeyValue<String, String> enumData) {
        this.data = data;
        this.code = enumData.getKey();
        this.msg = enumData.getValue();
    }

    public static <T> Ret<T> success() {
        return new Ret<>(BusRetEnum.SUCCESS);
    }

    public static <T> Ret<T> success(T data) {
        return new Ret(data, BusRetEnum.SUCCESS);
    }

    public static <T> Ret<T> fail() {
        return new Ret<>(BusRetEnum.FAIL);
    }

    public static <T> Ret<T> fail(T data) {
        return new Ret<>(data, BusRetEnum.FAIL);
    }

    public static <T> Ret<T> fail(BusRetEnum busRetEnum) {
        return new Ret<>(BusRetEnum.FAIL);
    }

    public static <T> Ret<T> successOrFail(boolean successes) {
        BaseKeyValue<String, String> enumData = BusRetEnum.SUCCESS;
        if (!successes) {
            enumData = BusRetEnum.FAIL;
        }
        return new Ret<>(enumData);
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}