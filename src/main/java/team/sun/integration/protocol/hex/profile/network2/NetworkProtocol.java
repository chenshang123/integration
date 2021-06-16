package team.sun.integration.protocol.hex.profile.network2;

import team.sun.integration.protocol.hex.utils.ProfileConvert;

import java.util.ArrayList;
import java.util.List;

public class NetworkProtocol {

    public static final List<String> profile;

    static {
        List<String> protocol = new ArrayList<>(11);
        //key : val (字节长度_别名) math
        protocol.add(0, "1_year");//messageID
        protocol.add(1, "1_month");//报文类型
        protocol.add(2, "1_day");//报文序列号
        protocol.add(3, "1_hour");//预留1
        protocol.add(4, "1_minute");//预留2
        protocol.add(5, "1_second");//时间
        protocol.add(6, "2_speed");//终端编号
        protocol.add(7, "4_longitude");//电池电压
        protocol.add(8, "4_latitude");//芯片温度
        protocol.add(9, "2_voltage");//定时上报频率
        protocol.add(10, "2_temperature");//异常上报频率

//        profile = Collections.unmodifiableMap(protocol);
        profile = ProfileConvert.getFieldAndLength(protocol);
    }


    public static void main(String[] args) {
        System.out.println("123,,".split(",").length);
    }

}
