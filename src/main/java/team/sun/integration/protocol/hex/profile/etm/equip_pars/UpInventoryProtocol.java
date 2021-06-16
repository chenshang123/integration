package team.sun.integration.protocol.hex.profile.etm.equip_pars;

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
 * 1.5.2    1.5.4 盘存数据上传
 */
@Component
@ProtocolCode(3015)
public class UpInventoryProtocol extends HexConventHandlerAbstract {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(8);
        //key : val (字节长度_别名) math
        protocol.add(0, "4_code");//响应码 3015
        protocol.add(1, "4_topic");//消息主题
        protocol.add(2, "1_down_num");//个数
        protocol.add(3, "12_down_epcs");//出库数据
        protocol.add(4, "1_up_num");//个数
        protocol.add(5, "12_up_epcs");//入库数据
        protocol.add(6, "1_scan_num");//个数
        protocol.add(7, "12_scan_epcs");//当前库存

        profile = ProfileConvert.getFieldAndLength(protocol);

    }

    @Override
    public List<String> profileConvert() {
        return profile;
    }

    @Override
    public String toJsonString(Map<String, Object> data) {
        return "{\"topic\":\"feedback/" + data.get("topic") + "\",\"payload\":\"{'data':{'down_epcs':" + data.get("down_epcs") + ",'up_epcs':" + data.get("up_epcs") + ",'scan_epcs':" + data.get("scan_epcs") + "},'code':" + data.get("code") + "}\"}";
    }


    @Override
    public Object Parsing(Map<String, Object> param, Map<String, Object> data) {
        if (null != param.get("field_name") && null != param.get("field_Data")) {
            String fieldName = (String) param.get("field_name");
            byte[] fieldData = (byte[]) param.get("field_Data");
            param.get("field_length_correction_factor");
            if (!StringUtils.isEmpty(fieldName) && fieldData != null) {
                if ("down_num".equals(fieldName) || "up_num".equals(fieldName) || "scan_num".equals(fieldName)) {
                    int val = BasicTypeCovert.Bytes2Int_LE(fieldData);
                    param.put("field_length_correction_factor", val);
                    return val;
                } else if ("down_epcs".equals(fieldName) || "up_epcs".equals(fieldName) || "scan_epcs".equals(fieldName)) {
                    param.put("field_length_correction_factor", 1);

                    if (fieldData.length % 12 == 0) {
                        int num = fieldData.length / 12;
                        String[] epcS = new String[num];
                        for (int i = 0; i < num; i++) {
                            String epc = HexStringCovert.bytesToHexString(HexStringCovert.arraySub(fieldData, i * 12, (i + 1) * 12));
                            epcS[i] = epc;
                        }
                        return epcS;
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
