package team.sun.integration.common.msgCache;


import java.util.Map;


public class Message {
    private String id;
    private String data;
    private Map<String, Object> paras;

    public Message(String id, String data) {

        this.id = id;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getId() {
        return id;
    }
}
