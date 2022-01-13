package team.sun.integration.protocol.hex.profile.demo.unpack;

import team.sun.integration.protocol.hex.handler.ProtocolCode;
import team.sun.integration.protocol.hex.profile.UnpackProfileAbstract;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.ProfileConvert;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 智能警示牌 BC20
 */
@Component
@ProtocolCode(16385)
public class BC20 extends UnpackProfileAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(4);
        //key : val (字节长度_别名) math
        protocol.add(0, "4_code");
        protocol.add(1, "1_year");
        protocol.add(2, "1_month");
        protocol.add(3, "1_day");
        protocol.add(4, "1_hour");
        protocol.add(5, "1_minute");
        protocol.add(6, "1_second");
        protocol.add(7, "2_height");
        protocol.add(8, "4_longitude");
        protocol.add(9, "4_latitude");
        protocol.add(10, "2_voltage");
        protocol.add(11, "2_temperature");
        protocol.add(12, "4_count");
        protocol.add(13, "4_res1");
        protocol.add(14, "4_res2");
        protocol.add(15, "4_res3");
        protocol.add(16, "4_res4");
        protocol.add(17, "4_res5");
        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public List<String> profileConvert() {
        return profile;
    }

    @Override
    public String toJsonString(Map<String, Object> data) {
        return "";
    }


    @Override
    public Object unpack(Map<String, Object> param, Map<String, Object> data) {
        if (null != param.get("field_name") && null != param.get("field_Data")) {
            String fieldName = (String) param.get("field_name");
            byte[] fieldData = (byte[]) param.get("field_Data");
            if (StringUtils.hasLength(fieldName) && fieldData != null) {
                return BasicTypeCovert.Bytes2Int_LE(fieldData);
            }
        }

        return null;
    }

}
