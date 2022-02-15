package team.sun.integration.protocol.hex.profile.abstracts;

import java.util.List;
import java.util.Map;

public abstract class UnpackProfileAbstract {

    /**
     * 解析次数统计
     */
    abstract public void count(String key);

    abstract public String getKey(String HexString);

    abstract public List<String> profileConvert();

    abstract public Object unpack(Map<String, Object> param, Map<String, Object> data);
}
