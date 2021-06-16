package team.sun.integration.common.exception;

/**
 * 数据未找到异常
 *
 * @author gslyx2
 */
public class DataNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 8061747907232469130L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
}
