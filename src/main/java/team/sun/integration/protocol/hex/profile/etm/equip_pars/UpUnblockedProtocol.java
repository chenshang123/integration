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
 * 1.5.1 安全柜解锁信息
 */
@Component
@ProtocolCode(3011)
public class UpUnblockedProtocol extends HexConventHandlerAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(4);
        //key : val (字节长度_别名) math
        protocol.add(0, "4_code");//响应码 3011
        protocol.add(1, "4_topic");//消息主题
        protocol.add(2, "1_door");//命令编号
        protocol.add(3, "1_lock");//消息主题


        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public List<String> profileConvert() {
        return profile;
    }

    @Override
    public String toJsonString(Map<String, Object> data) {
        return "{\"topic\":\"feedback/" + data.get("topic") + "\",\"payload\":\"{'data':{'lock':" + data.get("lock") + ",'door':" + data.get("door") + "},'code':" + data.get("code") + "}\"}";
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
