package team.sun.integration.protocol.hex.handler;

import java.util.Map;

public class HandlerContext {

    private Map<Integer, Class> handlerMap;

    public HandlerContext(Map<Integer, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public  Object getInstance(Integer type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }
        return BeanTool.getBean(clazz);
    }
}
