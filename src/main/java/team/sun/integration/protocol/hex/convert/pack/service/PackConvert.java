package team.sun.integration.protocol.hex.convert.pack.service;

import cn.hutool.core.util.HexUtil;
import team.sun.integration.protocol.hex.convert.pack.PackConvertService;
import team.sun.integration.protocol.hex.profile.PackProfileAbstract;
import team.sun.integration.protocol.hex.scann.ReflectionProfile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析配置文件转换
 * 根据文档说明，实现数据封装方法
 *
 * @author chens
 */
public class PackConvert implements PackConvertService {

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
        //当前字段长度修正系数(默认1)
        int field_length_correction_factor = 1;
        param.put("field_length_correction_factor", field_length_correction_factor);
        PackProfileAbstract hexConventHandler = (PackProfileAbstract) ReflectionProfile.getBean(getProtocolCode(data));
        //解释翻译对象
        List<String> profile = hexConventHandler.profileConvert();
        param.put("hex_string", "");
        StringBuilder stringBuffer = new StringBuilder();
        if (profile.size() > 2 && data != null) {
            List<String> nameS = Arrays.asList(profile.get(1).split(","));
            List<String> byteS = Arrays.asList(profile.get(2).split(","));
            for (int i = 0; i < byteS.size(); i++) {
                int fieldLength = Integer.parseInt(byteS.get(i));
                param.put("field_name", nameS.get(i));
                param.put("field_length", fieldLength);
                String fieldStrData = hexConventHandler.pack(param, data);
                if (fieldStrData != null) {
                    stringBuffer.append(fieldStrData);
                }
            }
        }

        return HexUtil.decodeHex(stringBuffer.toString());
    }

    @Override
    public String getPackMap(Map<String, Object> data) {
        PackProfileAbstract hexConventHandler = (PackProfileAbstract) ReflectionProfile.getBean(getProtocolCode(data));
        return hexConventHandler.toJsonString(data);
    }

}
