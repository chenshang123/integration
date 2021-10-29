package team.sun.integration.protocol.hex.profile.demo.unpack;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import team.sun.integration.protocol.hex.handler.ProtocolCode;
import team.sun.integration.protocol.hex.profile.UnpackProfileAbstract;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.ProfileConvert;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 报文协议解析（byte转对象）
 */
@Component
@ProtocolCode(1000)
public class DemoUnpackProtocol extends UnpackProfileAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(4);
        //key : val (字节长度_别名) math
        protocol.add(0, "4_code");//响应码 3010
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
    public String toJsonString(Map<String, Object> data){
        return "{\"topic\":\"feedback/"+data.get("topic")+"\",\"payload\":\"{\\\"data\\\":{\\\"lock\\\":"+data.get("lock")+",\\\"door\\\":"+data.get("door")+"},\\\"code\\\":"+data.get("code")+"}\"}";
    }


    @Override
    public Object unpack(Map<String, Object> param, Map<String, Object> data) {
        if(null != param.get("field_name") && null != param.get("field_Data")){
            String fieldName = (String) param.get("field_name");
            byte[] fieldData = (byte[]) param.get("field_Data");
            if(!StringUtils.isEmpty(fieldName) && fieldData != null){
                return BasicTypeCovert.Bytes2Int_LE(fieldData);
            }
        }

        return null;
    }

    public static void main(String[] args) throws IOException {

        String json;
        json = "{\"topic\":\""+1+"\",\"payload\":\"{'data':{'lock':"+1+",'door':"+1+"},'code':"+1+"}\"}";
        //        Map<String, Object> param = JsonUtils.readFromJson(json, Map.class);
        JSONObject jb = JSON.parseObject(json);
        Set<Map.Entry<String, Object>> set = jb.entrySet();
        for(Map.Entry<String, Object> entry: set){
            System.out.println(entry.getKey()+","+entry.getValue().toString());
        }
    }
}
