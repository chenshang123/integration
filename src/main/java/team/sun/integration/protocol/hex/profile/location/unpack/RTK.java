package team.sun.integration.protocol.hex.profile.location.unpack;

import team.sun.integration.protocol.hex.scann.ProtocolCode;
import team.sun.integration.protocol.hex.profile.abstracts.UnpackProfileAbstract;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.HexStringCovert;
import team.sun.integration.protocol.hex.utils.ProfileConvert;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 智能接地线 RTK
 */
@Component
@ProtocolCode(20481)
public class RTK extends UnpackProfileAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(4);
        //key : val (字节长度_别名) math

        protocol.add(0, "4_type");
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
        protocol.add(12, "4_id");
        protocol.add(13, "4_sendID0");
        protocol.add(14, "4_sendID1");
        protocol.add(15, "4_sendID2");
        protocol.add(16, "4_sendID3");
        protocol.add(17, "4_sendID4");
        protocol.add(18, "4_sendID5");
        protocol.add(19, "4_sendID6");
        protocol.add(20, "4_sendID7");
        protocol.add(21, "4_sendID8");
        //设备状态通过2进制表示，1正常 0 关闭
        protocol.add(22, "2_status");
        protocol.add(23, "4_res1");
        protocol.add(24, "4_res2");
        protocol.add(25, "4_res3");
        protocol.add(26, "4_res4");
        protocol.add(27, "4_res5");
        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public void count() {

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
                if (fieldName.equals("status")) {
                    return HexStringCovert.bytesToBinaryString(fieldData);
                }
                return BasicTypeCovert.Bytes2Int_LE(fieldData);
            }
        }

        return null;
    }

}
