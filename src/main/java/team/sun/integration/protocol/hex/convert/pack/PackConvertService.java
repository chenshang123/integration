package team.sun.integration.protocol.hex.convert.pack;

import java.util.Map;

public interface PackConvertService {

     /**
      * 获取协议编号
      * @param data profile参数
      * @return     编号
      */
     int getProtocolCode(Map<String, Object> data);

     /**
      * 对象数据转byte
      * @param data 原始数据
      * @return     数组
      */
     byte[] toByteArray(Map<String, Object> data);

     Map<String, Object> getPackMap(Map<String, Object> data);
}
