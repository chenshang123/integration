package team.sun.integration.common.constant;

/**
 * web常量
 *
 * @author TaoYu
 */
public class CommonConstants {

    /**
     * 验证码在session中的key
     */
    public static final String CAPTCHA_SESSION_CODE = "captchaCode";
    /**
     * 验证码在session中的时间
     */
    public static final String CAPTCHA_SESSION_DATE = "captchaDate";
    /**
     * 当前用户在session中的key
     */
    public static final String CURRENT_USER = "currentUser";

    /**
     * 当前用户的ID
     */
    public static final String USER_ID = "USER_ID";
    /**
     * 当前用户的NAMES
     */
    public static final String USER_NAME = "USER_NAME";
    /**
     * 当前用户的单位ID
     */
    public static final String ORG_ID = "ORG_ID";
    /**
     * 当前用户的登录IP
     */
    public static final String LOGIN_IP = "LOGIN_IP";
    /**
     * 当前用户是否是管理员
     */
    public static final String IS_ADMIN = "IS_ADMIN";

    /**
     * token
     */
    public static final String TOKEN = "Authorization";

    /**
     * redis 存用户信息的token
     */
    public static final String REDIS_USER_INFO_PREFIX = "SYSTEM:TOKEN_PREFIX:";
    /**
     * redis 存用户单位信息
     */
    public static final String REDIS_USER_ORG_INFO_PREFIX = "SYSTEM:USER_ORG_PREFIX:";

    /**
     * redis 存用户权限
     */
    public static final String REDIS_USER_AUTH_PREFIX = "SYSTEM:AUTH_PREFIX:";

    /**
     * redis 用户验证码前缀
     */
    public static final String REDIS_IMAGE_CODE_PREFIX = "SYSTEM:IMAGE_PREFIX:";
}
