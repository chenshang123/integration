package team.sun.integration.common.utils;

public class Regex {
    public static final String NAME = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]{3,12}$";
    public static final String IDENTIFY = "^[a-zA-Z0-9]{3,20}$";
    public static final String USERNAME = "^[a-zA-Z]{1}([a-zA-Z0-9]|[-_]){3,15}$";
    public static final String PASSWORD = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_!@#$%^&*`~()-+=]+$)(?![a-z0-9]+$)(?![a-z\\W_!@#$%^&*`~()-+=]+$)(?![0-9\\W_!@#$%^&*`~()-+=]+$)[a-zA-Z0-9\\W_!@#$%^&*`~()-+=]{8,20}$";
    public static final String MOBILE = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9])|166|198|199)\\d{8}$";
    public static final String EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static final String CHINESE = "^[\\u4e00-\\u9fa5]{2,20}$";
    public static final String NUM = "[0-9]+";
    public static final String URL = "^(?=^.{3,255}$)(http(s)?://)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(/\\w+\\.\\w+)*$";
    public static final String IP_ADDR = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";
    public static final String BIRTHDAY = "(19|20)\\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])";
    public static final String SPECIAL_CHARACTERS = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

    public Regex() {
    }
}
