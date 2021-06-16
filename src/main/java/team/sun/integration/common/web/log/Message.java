package team.sun.integration.common.web.log;

/**
 * @author QinC
 * @create 2018-10-09 14:39
 */
public class Message {
    /**
     * 操作
     */
    private String operation;
    /**
     * 描述
     */
    private String content;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
