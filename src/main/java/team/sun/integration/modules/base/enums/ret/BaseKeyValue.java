package team.sun.integration.modules.base.enums.ret;

import java.io.Serializable;

/**
 * 枚举或者错误码的接口
 *
 * @author zopin
 */
public interface BaseKeyValue<K, V> extends Serializable {

    K getKey();

    V getValue();
}