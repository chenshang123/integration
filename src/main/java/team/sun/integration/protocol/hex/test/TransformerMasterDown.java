package team.sun.integration.protocol.hex.test;

import cn.hutool.core.util.HexUtil;
import team.sun.integration.protocol.hex.utils.BasicTypeCovert;
import team.sun.integration.protocol.hex.utils.HexStringCovert;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransformerMasterDown {
    /*起始符*/
    private static String start1_H = "68";
    /*长度 长度 L   控制域、地址域、链路用户数据（应用层）的字节总数  2字节 D0=0、D1=1*/
    private static String L_H = "5200";
    private static String D1D0 = "10";
    private static String D15D2 = "11010"; // 26字节
    /*起始符*/
    private static String start2_H = "68";
    /*控制域 C*/
    private static String C_H = "34"; //34

    private static String DIR_D7 = "0";/*传输方向位 0下行 1上行*/
    private static String PRM_D6 = "0";/*启动标志位 0启动站 1从站*/
    private static String FCB_D5 = "1";/*帧计数位 */
    private static String FCV_D4 = "1";/*帧计数有效位 FCV=1，表示FCB位有效；FCV=0，表示FCB位无效。*/
    private static String function_code_D3D0 = "0100";/*功能码 11-1011   4- 0100 请求2级数据*/

    /*地址域 A*/
    private static String A_H = "0151010002";
    private static String A1_H = "0151";/*地址域 A 2字节*/
    private static String A2_H = "0100";/*地址域 A 2字节*/
    /* 可能数据 10表示02 11表示03*/
    private static String A3_H = "02";/*地址域 A 1字节*/
    private static String A3_D0 = "0";/*地址域 A D0=0表示终端地址A2为单地址；D0=1表示终端地址A2为组地址； */
    /*
    a）	主站启动的发送帧的MSA应为非零值，其终端响应帧的MSA应与主站发送帧的MSA相同。
    b）	终端启动发送帧的MSA应为零，其主站响应帧的MSA也应为零。
    组成0_127个主站地址MSA。
    * */
    private static String A3_MSA_D7D1 = "1";

    /*应用层 AFN*/
    private static String AFN_H = "0D";
    /*帧序列域SEQ*/
    private static String SEQ_H = "F1"; //E1
    private static String TpV_D7 = "1"; //帧时间标签有效位 TpV=0，表示在附加信息域中无时间标签Tp；TpV=1，表示在附加信息域中带有时间标签Tp
    private static String FIR_D6 = "1"; //首帧标志FIR  单帧
    private static String FIN_D5 = "1"; //末帧标志FIN 单帧
    private static String CON_D4 = "1"; //请求确认标志位CON  CON位置“1”，表示需要对该帧报文进行确认；置“0”，表示不需要对该帧报文进行确认。
    private static String PSEQ_D3D0 = "0001"; //启动帧序号PSEQ  PSEQ取自1字节的启动帧计数器PFC的低4位计数值0～15。
    private static String RSEQ = ""; //响应帧序号RSEQ
    /*信息点DA pn*/
    private static String DA;
    private static String DA1 = "FF"; //
    private static String DA2 = "00"; //0-255 00表示所有
    /*信息类DT fn  F450 二次电压有效值曲线*/
    private static String DT = "";
    private static String DT1 = "02"; //
    private static String DT2 = "38"; //0-255  00表示所有
    /*数据内容*/
    private static String data;
    private static String data_ts = "0016271220"; //分时日月年
    private static String data_m = "01"; //01 FE 冻结密度 密度m 1-15/30/45 254-5/10/15
    private static String data_n = "05"; //数据点数
    //组号
    private static String group_code_H = "02";
    /*Tp 时间标签*/
    private static String Tp;
    /*启动帧*/
    private static String PFC_H = "01";
    private static String send_time_s = "00000929";
    /*启动帧发送时 秒分时日*/
    /*允许发送传输延时时间 */
    private static String delayed = "FF";
    /*CS 帧校验和*/
    /*帧校验和 控制域、地址域、链路用户数据（应用层）三部分。
     * 帧校验和是用户数据区所有字节的八位位组算术和*/
    private static String CS = "";
    /*结束*/
    private static String end = "16";
    private Integer PFC = 1; //0_255的启动帧帧序号计数器PFC

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        send_time_s = localTime.getSecond() + "" + localTime.getMinute() + localTime.getHour() + localDate.getDayOfMonth();
        System.err.println(localTime + "当前>" + send_time_s);


        String DA = DA1 + DA2;
        String DT = DT1 + DT2;
        String data = data_ts + data_m + data_n;
        String Tp = PFC_H + send_time_s + delayed;
        Tp = "";
        String msg = C_H + A_H + AFN_H + SEQ_H + DA + DT + data + group_code_H + Tp;


        System.out.println("msg--------" + msg);

        L_H = Integer.toBinaryString(msg.length() / 2);
        int length = Integer.parseInt(L_H + "10", 2);
        L_H = HexUtil.encodeHexStr(BasicTypeCovert.getBytes(length)).substring(0, 4);
        System.out.println(Integer.toBinaryString(msg.length()) + "msg长度--------" + L_H);
        String head = start1_H + L_H + L_H + start1_H;

        byte[] bytes = HexUtil.decodeHex(AFN_H + SEQ_H + DA + DT + data + group_code_H + Tp);
        int a = 0;
        byte[] bytes2 = new byte[1];
        for (int i = 0; i < bytes.length; i++) {
            bytes2[0] = bytes[i];
            a += BasicTypeCovert.Bytes2Int_LE(bytes2);
        }
        bytes2[0] = BasicTypeCovert.getBytes(a)[0];
        String csStr = HexUtil.encodeHexStr(BasicTypeCovert.getBytes(a));
        CS = csStr.substring(0, 2);

        System.out.println("完整报文：" + head + msg + CS + end);


    }

}
