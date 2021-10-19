package team.sun.integration.protocol.hex.utils;

import org.jetbrains.annotations.Contract;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexStringCovert {

    private static final Pattern hexPattern = Pattern.compile("^[0-9a-fA-F]+$");

    public static boolean isHexString(String str) {
        str = str.replace(" ", "");
        Matcher m = hexPattern.matcher(str);
        return m.matches();
    }

    /**
     * 截取数组并顺序排列
     */
    @Contract(pure = true)
    public static byte[] arraySub(byte[] data, int start, int end) {
        int size = end - start;
        byte[] bytes = new byte[size];
        int j = 0;
        for (int i = start; i < end; i++) {
            bytes[j] = data[i];
            j++;
        }
        return bytes;//返回截取数组的地址
    }

    /**
     * 截取数组并倒序排列
     */
    @Contract(pure = true)
    public static byte[] arraySubDesc(byte[] data, int start, int end) {
        int size = end - start;
        byte[] bytes = new byte[size];
        int j = 1;
        for (int i = start; i < end; i++) {
            bytes[size - j] = data[i];
            j++;
        }
        return bytes;//返回截取数组的地址
    }

    public static String convertByteArrayToHexString(byte[] byte_array) {
        StringBuilder s = new StringBuilder();
        if (byte_array == null) {
            return s.toString();
        } else {
            for (byte b : byte_array) {
                String hex = Integer.toHexString(b & 255);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                s.append(hex);
            }
            return s.toString().toUpperCase();
        }
    }

    public static String convertByteArrayToHexWordString(byte[] byte_array) {
        StringBuilder s = new StringBuilder();
        if (byte_array != null) {
            for (int i = 0; i < byte_array.length; i += 2) {
                String hex1 = Integer.toHexString(byte_array[i] & 255);
                String hex2 = Integer.toHexString(byte_array[i + 1] & 255);
                if (hex1.length() == 1) {
                    hex1 = "0" + hex1;
                }
                if (hex2.length() == 1) {
                    hex2 = "0" + hex2;
                }
                s.append(hex1).append(hex2);
            }
        }
        return s.toString();
    }

    /**
     * 把16进制字符串转换成字节数组
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] charV = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(charV[pos]) << 4 | toByte(charV[pos + 1]));
        }
        return result;
    }

    /**
     * 数组转换成十六进制字符串
     */
    public static String bytesToHexString(byte[] bArray) {
        StringBuilder sb = new StringBuilder(bArray.length);
        String sTemp;
        for (byte b : bArray) {
            sTemp = Integer.toHexString(0xFF & b);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    private static int toByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

//        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
//        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        LocalDate today = LocalDate.now();
//        int a = 1603776467919;
        System.out.println(new Date().getTime());
        byte[] bytes = "大家好啊".getBytes("GB2312");
        String hexStr = convertByteArrayToHexString(bytes);
        System.out.println(hexStr);
        String wordStr = convertByteArrayToHexWordString(bytes);
        System.out.println(wordStr);
    }
}
