package team.sun.integration.protocol.hex.profile.etm.equip_pars;

import team.sun.integration.protocol.hex.handler.HexConventHandlerAbstract;
import team.sun.integration.protocol.hex.handler.ProtocolCode;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.ProfileConvert;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 1.5.6 设备发送设置设备编号命令
 */
@Component
@ProtocolCode(2201)
public class UpRequestEquipNoProtocol extends HexConventHandlerAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(2);
        //key : val (字节长度_别名) math
        protocol.add(0, "4_command");//命令编号 2201
        protocol.add(1, "4_topic");//消息主题

        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public List<String> profileConvert() {
        return profile;
    }

    @Override
    public String toJsonString(Map<String, Object> data) {
        return "{\"topic\":\"request/" + data.get("topic") + "\",\"payload\":\"{\\\"command/\":" + data.get("command") + "}\"}";
    }


    @Override
    public Object Parsing(Map<String, Object> param, Map<String, Object> data) {
        if (null != param.get("field_name") && null != param.get("field_Data")) {
            String fieldName = (String) param.get("field_name");
            byte[] fieldData = (byte[]) param.get("field_Data");
            if (!StringUtils.isEmpty(fieldName) && fieldData != null) {
                return BasicTypeCovert.Bytes2Int_LE(fieldData);
            }
        }

        return null;
    }

    @Override
    public String packaging(Map<String, Object> param, Map<String, Object> data) {
        return null;
    }
}
