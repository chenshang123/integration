package team.sun.integration.protocol.hex.handler;

import java.util.List;
import java.util.Map;

public abstract class HexConventHandlerAbstract {

    abstract public List<String> profileConvert();

    abstract public String toJsonString(Map<String, Object> data);

    abstract public Object Parsing(Map<String, Object> param, Map<String, Object> data);

    abstract public String packaging(Map<String, Object> param, Map<String, Object> data);
}
