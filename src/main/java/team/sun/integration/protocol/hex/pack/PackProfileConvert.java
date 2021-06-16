package team.sun.integration.protocol.hex.pack;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import team.sun.integration.protocol.hex.handler.HexConventHandlerAbstract;
import team.sun.integration.protocol.hex.handler.HexHandlerContext;
import team.sun.integration.protocol.hex.utils.HexStringCovert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 解析配置文件转换
 * 根据文档说明，实现解析数据方法
 *
 * @author chens
 */
@Component
public class PackProfileConvert implements PackProfileConvertService {

    //当前字段长度修正系数(默认1)
    private final int field_length_correction_factor = 1;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private HexHandlerContext hexHandlerContext;

    @Override
    public int getProtocolCode(Map<String, Object> data) {
        int protocolCode = 0;
        if (null != data) {
            if (null != data.get("code")) {
                protocolCode = (int) data.get("code");
            } else if (null != data.get("command")) {
                protocolCode = (int) data.get("command");
            }
        }

        return protocolCode;
    }

    @Override
    public byte[] toByteArray(Map<String, Object> data) {
        Map<String, Object> param = new HashMap<>();
        //当前字段长度修正系数(默认1)，实际长度=字段长度*field_length_correction_factor
        param.put("field_length_correction_factor", field_length_correction_factor);
        HexConventHandlerAbstract hexConventHandler = hexHandlerContext.getInstance(getProtocolCode(data));
        //解释翻译对象
        List<String> profile = hexConventHandler.profileConvert();
        param.put("hex_string", "");
        StringBuffer stringBuffer = new StringBuffer();
        if (null != hexConventHandler && profile.size() > 2 && data != null) {
            int length = Integer.parseInt(profile.get(0));
            List<String> nameS = Arrays.asList(profile.get(1).split(","));
            List<String> byteS = Arrays.asList(profile.get(2).split(","));
            int byteArrayStartIndex = 0;
            for (int i = 0; i < byteS.size(); i++) {
                int modifyVal = (int) param.get("field_length_correction_factor");
                int fieldLength = Integer.parseInt(byteS.get(i));
                param.put("field_name", nameS.get(i));
                param.put("field_length", fieldLength);
                String fieldStrData = hexConventHandler.packaging(param, data);
                if (fieldStrData != null) {
                    stringBuffer.append(fieldStrData);
                }

            }

        }

        return HexStringCovert.hexStringToByte(stringBuffer.toString());
    }

    @Override
    public Map<String, Object> getPackMap(Map<String, Object> data) {
        int code = getProtocolCode(data);
        HexConventHandlerAbstract hexConventHandler = hexHandlerContext.getInstance(getProtocolCode(data));
        String jsonData = hexConventHandler.toJsonString(data);
        JSONObject jb = JSON.parseObject(jsonData);
        return jb.getInnerMap();
    }


}
