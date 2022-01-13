package team.sun.integration.protocol.hex.convert.unpack.sevice;

import cn.hutool.core.util.HexUtil;
import team.sun.integration.protocol.hex.convert.unpack.UnpackConvertService;
import team.sun.integration.protocol.hex.handler.HandlerContext;
import team.sun.integration.protocol.hex.profile.UnpackProfileAbstract;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.HexStringCovert;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 解析配置文件转换
 * 根据文档说明，实现解析数据方法
 *
 * @author chens
 */
@Component
public class UnpackConvert implements UnpackConvertService {

    private final HandlerContext hexHandlerContext;

    @Autowired
    public UnpackConvert(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") HandlerContext hexHandlerContext) {
        this.hexHandlerContext = hexHandlerContext;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

//        String text = "AQJSAAAAAABe4zKaC/NjIQFkATkAPAUDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC/PYUQFkAScAAAACAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAv0TYEBZgEjAACWeAAATiAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=";
//        final Base64.Decoder decoder = Base64.getDecoder();
//        byte[] decode = decoder.decode(text);

        byte[] bytes = "大家好啊".getBytes("GB2312");
        System.out.println(HexUtil.encodeHex(bytes));
        bytes = HexUtil.decodeHex("B4F3BCD2BAC3B0A10000000");
        System.out.println(new String(bytes, "GB2312"));
        System.out.println(Integer.parseInt(String.format("%s", "1234567".charAt(4))));


    }

    @Override
    public int getProtocolCode(byte[] data) {
        byte[] fieldData = HexStringCovert.arraySub(data, 0, 4);
        return BasicTypeCovert.Bytes2Int_LE(fieldData);
    }

    /**
     * 数据解析：字段与值对应,转为map
     *
     * @param data 报文hex数据
     * @return Map(key ： 字段名称 value ： 值)
     */
    @NotNull
    public Map<String, Object> toMap(byte[] data) {
        Map<String, Object> param = new HashMap<>();
        //当前字段长度修正系数(默认1)，时间长度=字段长度*field_length_correction_factor
        //当前字段长度修正系数(默认1)
        int field_length_correction_factor = 1;
        param.put("field_length_correction_factor", field_length_correction_factor);
        UnpackProfileAbstract hexConventHandler = (UnpackProfileAbstract) hexHandlerContext.getInstance(getProtocolCode(data));
        //解释翻译对象
        List<String> profile = hexConventHandler.profileConvert();

        Map<String, Object> result = new HashMap<>();
        if (profile.size() > 2 && data.length > 0) {
            int count = Integer.parseInt(profile.get(0));
            if (count == data.length) {
                List<String> nameS = Arrays.asList(profile.get(1).split(","));
                List<String> byteS = Arrays.asList(profile.get(2).split(","));
                int byteArrayStartIndex = 0;

                for (int i = 0; i < byteS.size(); i++) {
                    int modifyVal = (int) param.get("field_length_correction_factor");
                    int val = Integer.parseInt(byteS.get(i)) * modifyVal;

                    byte[] fieldData = HexStringCovert.arraySub(data, byteArrayStartIndex, byteArrayStartIndex + val);
                    //如果小于等于4个字节字节转int,大于四个暂时不处理
                    param.put("field_name", nameS.get(i));
                    param.put("field_Data", fieldData);
                    result.put(nameS.get(i), hexConventHandler.unpack(param, result));

                    byteArrayStartIndex += val;
                }
            }
        }

        return toLayer(result, profile);

    }
    //以下方法后期优化，提出来重新处理

    @Override
    public Map<String, Object> toMap(byte[] data, List<String> profile) {
        Map<String, Object> result = new HashMap<>();
        if (profile.size() > 2 && data.length > 0) {
            int count = Integer.parseInt(profile.get(0));
            if (count == data.length) {
                List<String> nameS = Arrays.asList(profile.get(1).split(","));
                List<String> byteS = Arrays.asList(profile.get(2).split(","));
                int byteArrayStartIndex = 0;

                for (int i = 0; i < byteS.size(); i++) {
                    int val = Integer.parseInt(byteS.get(i));

                    byte[] fieldData = HexStringCovert.arraySubDesc(data, byteArrayStartIndex, byteArrayStartIndex + val);
                    //如果小于等于4个字节字节转int,大于四个暂时不处理
                    result.put(nameS.get(i), BasicTypeCovert.Bytes2Int_LE(fieldData));

                    byteArrayStartIndex += val;
                }
            }
        }

        return toLayer(result, profile);
    }

    /**
     * 根据待处理类型，解析数据，封装成map对象。
     *
     * @param data    key：字段名称 value：值
     * @param profile profile index0 报文总长度
     *                格式如下：521（单位：字节）
     *                profile index1 字段名称字符串，中间逗号隔开
     *                格式如下：字段1，字段2，...
     *                profile index2 字段长度字符串，中间逗号隔开
     *                格式如下：长度1，长度2，...
     *                profile index3 下标大于等于3的字符串，为需要出的对象集合，中间逗号隔开；
     *                格式如下： 字段1，字段2，...，处理类型，对象名称
     * @return map
     */
    @NotNull
    private Map<String, Object> toLayer(Map<String, Object> data, @NotNull List<String> profile) {

        for (int i = 3; i < profile.size(); i++) {
            String[] fieldS;
            fieldS = profile.get(i).split(",");
            if (fieldS.length > 2) {
                String type = fieldS[fieldS.length - 2];
                //根据不同处理类型进行处理，需要再完善
                if (null != type && type.contains("for_")) {
                    int num = Integer.parseInt(type.replace("for_", ""));
                    this.toFor(data, num, fieldS);
                }

            }
        }
        return data;

    }

    private void toFor(Map<String, Object> data, int num, String[] fieldS) {
        String listName = fieldS[fieldS.length - 1];
        List<Map<String, Object>> lst = new ArrayList<>(num);
        for (int j = 1; j < num + 1; j++) {
            //为对象字段赋值
            int realFieldLength = fieldS.length - 2;
            Map<String, Object> vo = new HashMap<>(realFieldLength);
            for (int k = 0; k < realFieldLength; k++) {
                vo.put(fieldS[k], data.get(fieldS[k] + j));
                //移除原始数据
                data.remove(fieldS[k] + j);
            }
            //记录
            lst.add(vo);
        }
        data.put(listName, lst);

    }


}
