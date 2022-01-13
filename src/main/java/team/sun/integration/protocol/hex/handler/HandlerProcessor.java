package team.sun.integration.protocol.hex.handler;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "team.sun.integration.protocol.hex.profile";

    /**
     * 扫描@HandlerType，初始化HandlerContext，将其注册到spring容器
     *
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<Integer, Class> handlerMap = Maps.newHashMapWithExpectedSize(14);
        ClassScanner.scan(HANDLER_PACKAGE, ProtocolCode.class).forEach(clazz -> {
            // 获取注解中的类型值
            int type = clazz.getAnnotation(ProtocolCode.class).value();
            // 将注解中的类型值作为key，对应的类作为value，保存在Map中
            handlerMap.put(type, clazz);
        });
        // 初始化HandlerContext，将其注册到spring容器中
        HandlerContext context = new HandlerContext(handlerMap);
        configurableListableBeanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }


}
