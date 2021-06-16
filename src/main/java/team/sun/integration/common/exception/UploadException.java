package team.sun.integration.common.exception;

/**
 * 文件上传异常
 *
 * @author TaoYu
 */
public class UploadException extends RuntimeException {

    private static final long serialVersionUID = 94095654162685734L;

    public UploadException() {
        super();
    }

    public UploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadException(String message) {
        super(message);
    }

    public UploadException(Throwable cause) {
        super(cause);
    }

}
