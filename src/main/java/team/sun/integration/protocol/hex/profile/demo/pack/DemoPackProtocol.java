package team.sun.integration.protocol.hex.profile.demo.pack;

import cn.hutool.core.util.HexUtil;
import team.sun.integration.protocol.hex.handler.ProtocolCode;
import team.sun.integration.protocol.hex.profile.PackProfileAbstract;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.ProfileConvert;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 报文协议封装（对象转byte）
 */
@Component
@ProtocolCode(2002)
public class DemoPackProtocol extends PackProfileAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(2);
        //key : val (字节长度_别名) math
        protocol.add(0, "4_command");//命令编号
        protocol.add(1, "4_topic");//消息主题

        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public int getProtocolCode(byte[] data) {
        return 2002;
    }

    @Override
    public List<String> profileConvert() {
        return profile;
    }

    @Override
    public String toJsonString(Map<String, Object> data) {
        return null;
    }

    @Override
    public String pack(Map<String, Object> param, Map<String, Object> data) {
        if(null != param && null != param.get("field_name") && null != param.get("field_length")){
            String fieldName = (String) param.get("field_name");
            int fieldLength = (int) param.get("field_length");

            if(StringUtils.hasLength(fieldName) && fieldLength>0){

                //添加需要特殊处理逻辑
                if(fieldName.equals("topic")){
                    String topic = data.get(fieldName).toString().replace("command/", "");
                    data.replace(fieldName, Integer.parseInt(topic));
                }

                if(fieldLength < 5){
                    return HexUtil.encodeHexStr(BasicTypeCovert.Int2Bytes_LE_digit(Integer.parseInt(data.get(fieldName).toString()), fieldLength));
                }

            }
        }
        return null;
    }
}
