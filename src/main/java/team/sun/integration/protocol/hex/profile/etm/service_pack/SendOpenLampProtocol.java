package team.sun.integration.protocol.hex.profile.etm.service_pack;

import team.sun.integration.protocol.hex.handler.HexConventHandlerAbstract;
import team.sun.integration.protocol.hex.handler.ProtocolCode;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.HexStringCovert;
import team.sun.integration.protocol.hex.utils.ProfileConvert;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 1.5.8	系统开灯
 */
@Component
@ProtocolCode(2200)
public class SendOpenLampProtocol extends HexConventHandlerAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(4);
        //key : val (字节长度_别名) math
        protocol.add(0, "4_command");//命令编号 2200
        protocol.add(1, "4_topic");//消息主题
        protocol.add(2, "1_number");//灯编号
        protocol.add(3, "1_status");//灯状态

        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public List<String> profileConvert() {
        return profile;
    }

    @Override
    public String toJsonString(Map<String, Object> data) {
        return "{\"topic\":\"" + data.get("topic") + "\",\"payload\":\"{'command':" + data.get("command") + ",'number':" + data.get("number") + ",'status':" + data.get("status") + "}\"}";
    }

    @Override
    public Object Parsing(Map<String, Object> param, Map<String, Object> data) {
        return null;
    }


    @Override
    public String packaging(Map<String, Object> param, Map<String, Object> data) {
        if (null != param && null != param.get("field_name") && null != param.get("field_length")) {
            String fieldName = (String) param.get("field_name");
            int fieldLength = (int) param.get("field_length");

            if (!StringUtils.isEmpty(fieldName) && fieldLength > 0 && null != data.get(fieldName)) {
                if (fieldName.equals("topic")) {
                    String topic = data.get(fieldName).toString().replace("command/", "");
                    data.replace(fieldName, Integer.parseInt(topic));
                }
                if (fieldLength < 5 && fieldLength > 0) {//默认Int类型处理
                    return HexStringCovert.bytesToHexString(BasicTypeCovert.Int2Bytes_LE_digit(Integer.parseInt(data.get(fieldName).toString()), fieldLength));
                }
            }
        }
        return null;
    }
}
