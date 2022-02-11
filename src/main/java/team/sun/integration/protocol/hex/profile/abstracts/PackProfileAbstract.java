package team.sun.integration.protocol.hex.profile.abstracts;

import java.util.List;
import java.util.Map;

public abstract class PackProfileAbstract {

    abstract public int getProtocolCode(byte[] data);

    abstract public List<String> profileConvert();

    abstract public String pack(Map<String, Object> param, Map<String, Object> data);
}
