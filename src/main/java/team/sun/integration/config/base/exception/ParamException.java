package team.sun.integration.config.base.exception;

/**
 * 参数异常
 *
 * @author TaoYu
 */
public class ParamException extends RuntimeException {

    private static final long serialVersionUID = 7047554984718257396L;

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

}
