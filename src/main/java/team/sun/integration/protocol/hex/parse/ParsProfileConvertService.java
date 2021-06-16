package team.sun.integration.protocol.hex.parse;

import java.util.List;
import java.util.Map;

public interface ParsProfileConvertService {

    public int getProtocolCode(byte[] data);

    public Map<String, Object> toMap(byte[] data);

    public Map<String, Object> toMap(byte[] data, List<String> profiles);
}
