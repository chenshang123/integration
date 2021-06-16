package team.sun.integration.protocol.hex.pack;

import java.util.Map;

public interface PackProfileConvertService {
    public int getProtocolCode(Map<String, Object> data);

    public byte[] toByteArray(Map<String, Object> data);

    public Map<String, Object> getPackMap(Map<String, Object> data);
}
