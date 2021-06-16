package team.sun.integration.protocol.hex.profile.etm.equip_pars;

import team.sun.integration.protocol.hex.handler.HexConventHandlerAbstract;
import team.sun.integration.protocol.hex.handler.ProtocolCode;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.HexStringCovert;
import team.sun.integration.protocol.hex.utils.ProfileConvert;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 1.5.7  设备发送设置设备编号命令
 */
@Component
@ProtocolCode(3202)
public class UpEquipNoProtocol extends HexConventHandlerAbstract {

    public static final List<String> profile;

    static {
        //byteArrayStartIndex、byteArrayEndIndex不能作为value
        List<String> protocol = new ArrayList<>(4);
        //key : val (字节长度_别名) math
        protocol.add(0, "4_command");//命令编号 3202
        protocol.add(1, "4_topic");//消息主题
        protocol.add(2, "4_equipid");//设备编号
        protocol.add(3, "30_name");//设备名称 (中间不能有空格，字符编码集GB2312)

        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public List<String> profileConvert() {
        return profile;
    }

    @Override
    public String toJsonString(Map<String, Object> data) {
        return "{\"topic\":\"feedback/" + data.get("topic") + "\",\"payload\":\"{'command':" + data.get("command") + ",'data':{'equipid':" + data.get("equipid") + ",'name':'" + data.get("name") + "'}}\"}";
    }


    @Override
    public Object Parsing(Map<String, Object> param, Map<String, Object> data) {
        if (null != param.get("field_name") && null != param.get("field_Data")) {
            String fieldName = (String) param.get("field_name");
            byte[] fieldData = (byte[]) param.get("field_Data");
            if (!StringUtils.isEmpty(fieldName) && fieldData != null) {
                if ("name".equals(fieldName)) {
                    try {
                        //去掉补位字节
                        fieldData = HexStringCovert.hexStringToByte(HexStringCovert.bytesToHexString(fieldData).replaceAll("00", ""));
                        return new String(fieldData, "GB2312");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    return BasicTypeCovert.Bytes2Int_LE(fieldData);
                }

            }
        }

        return null;
    }

    @Override
    public String packaging(Map<String, Object> param, Map<String, Object> data) {
        return null;
    }
}
