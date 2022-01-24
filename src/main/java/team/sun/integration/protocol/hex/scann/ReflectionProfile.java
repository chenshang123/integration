package team.sun.integration.protocol.hex.scann;

import org.reflections8.Reflections;
import org.reflections8.scanners.TypeAnnotationsScanner;

import java.util.*;

/**
 * 协议解释文件扫描
 */
public class ReflectionProfile {

    private static final String HEX_PROFILE = "team.sun.integration.protocol.hex.profile";
    private static final Map<Integer, Class<?>> CLASS_NAME_FIELD_CACHE;

    static {
        Reflections reflections = new Reflections(HEX_PROFILE, new TypeAnnotationsScanner());
        Set<Class<?>> ENTITY_SET = reflections.getTypesAnnotatedWith(ProtocolCode.class, true);
        CLASS_NAME_FIELD_CACHE = new HashMap<Integer, Class<?>>(ENTITY_SET.size());
        ENTITY_SET.forEach(clazz -> {
            // 获取注解中的类型值
            Integer type = clazz.getAnnotation(ProtocolCode.class).value();
            // 将注解中的类型值作为key，对应的类作为value，保存在Map中
            CLASS_NAME_FIELD_CACHE.put(type, clazz);
        });
    }
    public static Object getBean(int protocolCode) {
        Class<?> clazz = CLASS_NAME_FIELD_CACHE.get(protocolCode);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + protocolCode);
        }
        return clazz;
    }

}
