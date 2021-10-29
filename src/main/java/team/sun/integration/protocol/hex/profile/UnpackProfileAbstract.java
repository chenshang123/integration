package team.sun.integration.protocol.hex.profile;

import java.util.List;
import java.util.Map;

public abstract class UnpackProfileAbstract {

    abstract public List<String> profileConvert();

    abstract public String toJsonString(Map<String, Object> data);

    abstract public Object unpack(Map<String, Object> param, Map<String, Object> data);
}
