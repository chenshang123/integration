package team.sun.integration.protocol.hex.profile.network2;


import team.sun.integration.protocol.hex.utils.ProfileConvert;

import java.util.ArrayList;
import java.util.List;

/**
 * 配网2.0 协议文档说明
 *
 * @author chens
 */
public class BuriedCableProtocol {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(19);
        //字节长度_别名
        protocol.add(0, "1_msgId");//messageID
        protocol.add(1, "1_msgType");//报文类型
        protocol.add(2, "1_msgSequence");//报文序列号
        protocol.add(3, "1_null");//预留1
        protocol.add(4, "4_null");//预留2
        protocol.add(5, "4_msgTime");//时间
        protocol.add(6, "4_terminalCode");//终端编号
        protocol.add(7, "2_volt");//电池电压
        protocol.add(8, "2_temperature");//芯片温度
        protocol.add(9, "2_upFrequency");//定时上报频率
        protocol.add(10, "1_abnormalFrequency");//异常上报频率
        protocol.add(11, "1_signalRankCount");//信号强度
        protocol.add(12, "4_sensorCode_for");//传感器编号
        protocol.add(13, "2_volt_for");//电池电压1
        protocol.add(14, "2_temperature_for");//芯片温度1
        protocol.add(15, "4_data_for");//数据1
        protocol.add(16, "4_threshold_for_end_30_sensor");//阈值1 (循环30次 ,集合名称：sensor)字段长度_字段名称
        protocol.add(17, "4_null");//预留3
        protocol.add(18, "4_null");//预留4
//		profile = Collections.unmodifiableMap(protocal);
        profile = ProfileConvert.getFieldAndLength(protocol);
    }

    public static void main(String[] args) {
        System.out.println("123,,".split(",").length);
    }

}
