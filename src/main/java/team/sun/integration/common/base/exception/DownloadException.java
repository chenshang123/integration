package team.sun.integration.common.base.exception;

/**
 * 文件下载异常
 *
 * @author TaoYu
 */
public class DownloadException extends RuntimeException {

    private static final long serialVersionUID = 3021850916642773904L;

    public DownloadException() {
        super();
    }

    public DownloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloadException(String message) {
        super(message);
    }

    public DownloadException(Throwable cause) {
        super(cause);
    }

}
