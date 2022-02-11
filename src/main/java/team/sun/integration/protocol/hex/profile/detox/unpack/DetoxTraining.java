package team.sun.integration.protocol.hex.profile.detox.unpack;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import team.sun.integration.protocol.hex.profile.abstracts.UnpackProfileAbstract;
import team.sun.integration.protocol.hex.scann.ProtocolCode;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.ProfileConvert;
import team.sun.integration.protocol.tcp.channel.CatchMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 眉山戒毒所 器械训练记录
 */
@Component
@ProtocolCode(304)
public class DetoxTraining extends UnpackProfileAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(4);
        //key : val (字节长度_别名) math

        protocol.add(0, "2_protocolCode");
        protocol.add(1, "2_collectorNo");
        protocol.add(2, "58_reserve");
        protocol.add(3, "2_end");

        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public void count() {
        //CatchMap.count.put();
    }

    @Override
    public List<String> profileConvert() {
        return profile;
    }

    @Override
    public Object unpack(Map<String, Object> param, Map<String, Object> data) {
        if (null != param.get("field_name") && null != param.get("field_Data")) {
            String fieldName = (String) param.get("field_name");
            byte[] fieldData = (byte[]) param.get("field_Data");
            if (StringUtils.hasLength(fieldName) && fieldData != null) {
                if (fieldName.equals("reserve")) {
                    return null;
                }
                return BasicTypeCovert.Bytes2Int_LE(fieldData);
            }
        }

        return null;
    }

}
