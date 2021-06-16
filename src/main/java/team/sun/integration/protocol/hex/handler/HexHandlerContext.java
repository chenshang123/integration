package team.sun.integration.protocol.hex.handler;

import java.util.Map;

public class HexHandlerContext {

    private Map<Integer, Class> handlerMap;

    public HexHandlerContext(Map<Integer, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public HexConventHandlerAbstract getInstance(Integer type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }
        return (HexConventHandlerAbstract) BeanTool.getBean(clazz);
    }

}
