package team.sun.integration.protocol.hex.convert.unpack;

import java.util.List;
import java.util.Map;

public interface UnpackConvertService {
    /**
     * 获取协议编号
     *
     * @param data profile参数
     * @return 编号
     */
    int getProtocolCode(byte[] data);

    int getProtocolCode(byte[] data, int index, int length);

    void cont(String HexString, int protocolCode);
    /**
     * byte数据转对象
     *
     * @param data 原始数据
     * @return 数组
     */
    Map<String, Object> toMap(byte[] data, int protocolCode);

    Map<String, Object> toMap(byte[] data);
    /**
     * byte数据转对象
     * 报文协议不存在协议编号的时候，手动调用
     */
    Map<String, Object> toMap(byte[] data, List<String> profiles);
}
