package team.sun.integration.protocol.hex.profile.network2;

import team.sun.integration.protocol.hex.utils.ProfileConvert;

import java.util.ArrayList;
import java.util.List;

public class LocationProtocol {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(10);
        //key : val (字节长度_别名) math
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

//        profile = Collections.unmodifiableMap(protocal);
        profile = ProfileConvert.getFieldAndLength(protocol);
    }


    public static void main(String[] args) {
        System.out.println("123,,".split(",").length);
    }

}
