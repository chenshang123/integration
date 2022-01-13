package team.sun.integration.common.base.exception;

/**
 * 业务异常
 *
 * @author TaoYu
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -232388151980021793L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }


}
