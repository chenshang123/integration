package team.sun.integration.protocol.hex.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.Charset;

public class BasicTypeCovert {

    /**
     * int转换为小端byte[]（高位放在高地址中）
     *
     * @param iValue 整数
     * @param digit  字节个数
     * @return 字节数组
     */
    @Contract(pure = true)
    public static byte[] Int2Bytes_LE_digit(int iValue, int digit) {
        byte[] rst = new byte[digit];
        if (digit > 0) {
            // 先写int的最后一个字节
            rst[0] = (byte) (iValue & 0xFF);
        }
        if (digit > 1) {
            // int 倒数第二个字节
            rst[1] = (byte) ((iValue & 0xFF00) >> 8);
        }
        if (digit > 2) {
            // int 倒数第三个字节
            rst[2] = (byte) ((iValue & 0xFF0000) >> 16);
        }
        if (digit > 3) {
            // int 第一个字节
            rst[3] = (byte) ((iValue & 0xFF000000) >> 24);
        }

        return rst;
    }

    /**
     * int转换为小端byte[]（高位放在高地址中）
     *
     * @param iValue 整数
     * @return 字节数组
     */
    public static byte[] Int2Bytes_LE(int iValue) {
        byte[] rst = new byte[4];
        // 先写int的最后一个字节
        rst[0] = (byte) (iValue & 0xFF);
        // int 倒数第二个字节
        rst[1] = (byte) ((iValue & 0xFF00) >> 8);
        // int 倒数第三个字节
        rst[2] = (byte) ((iValue & 0xFF0000) >> 16);
        // int 第一个字节
        rst[3] = (byte) ((iValue & 0xFF000000) >> 24);
        return rst;
    }

    /**
     * int转换为大端byte[]（低位在前）
     *
     * @param iValue 整数
     * @return 字节数组
     */
    public static byte[] Int2Bytes_BE(int iValue) {
        byte[] rst = new byte[4];
        // 先写int的最后一个字节
        rst[3] = (byte) (iValue & 0xFF);
        // int 倒数第二个字节
        rst[2] = (byte) ((iValue & 0xFF00) >> 8);
        // int 倒数第三个字节
        rst[1] = (byte) ((iValue & 0xFF0000) >> 16);
        // int 第一个字节
        rst[0] = (byte) ((iValue & 0xFF000000) >> 24);
        return rst;
    }

    /**
     * int(小端)（高位在前）
     */
    public static Integer Bytes2Int_LE(byte[] bytes) {
        Integer iRst = null;
        if (null != bytes && bytes.length > 0 && bytes.length < 5) {
            iRst = (bytes[0] & 0xFF);
            for (int i = 1; i < bytes.length; i++) {
                iRst |= (bytes[i] & 0xFF) << 8 * i;
            }
        }
        return iRst;
    }

    /**
     * int大端
     */
    public static Integer Bytes2Int_BE(byte[] bytes) {
        Integer iRst = null;
        if (null != bytes && bytes.length > 0 && bytes.length < 5) {
            iRst = (bytes[bytes.length - 1] & 0xFF);
            for (int i = 1; i < bytes.length; i++) {
                iRst |= (bytes[bytes.length - 1 - i] & 0xFF) << 8 * i;
            }
        }
        return iRst;
    }


    /**
     * short to byte[]
     */
    public static byte[] getBytes(short data) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data & 0xff00) >> 8);
        return bytes;
    }

    /**
     * char to byte[]
     */
    public static byte[] getBytes(char data) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data);
        bytes[1] = (byte) (data >> 8);
        return bytes;
    }

    /**
     * long to byte[]
     */
    public static byte[] getBytes(long data) {
        byte[] bytes = new byte[8];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data >> 8) & 0xff);
        bytes[2] = (byte) ((data >> 16) & 0xff);
        bytes[3] = (byte) ((data >> 24) & 0xff);
        bytes[4] = (byte) ((data >> 32) & 0xff);
        bytes[5] = (byte) ((data >> 40) & 0xff);
        bytes[6] = (byte) ((data >> 48) & 0xff);
        bytes[7] = (byte) ((data >> 56) & 0xff);
        return bytes;
    }

    /**
     * float to byte
     */
    public static byte[] getBytes(float data) {
        int intBits = Float.floatToIntBits(data);
        return getBytes(intBits);
    }

    /**
     * double to byte[]
     */
    public static byte[] getBytes(double data) {
        long intBits = Double.doubleToLongBits(data);
        return getBytes(intBits);
    }

    /**
     * String to byte[]
     */
    public static byte[] getBytes(String data, String charsetName) {
        Charset charset = Charset.forName(charsetName);
        return data.getBytes(charset);
    }

    /**
     * String to byte[]
     */
    public static byte[] getBytes(String data) {
        return getBytes(data, "GBK");
    }

    /**
     * bytes to short
     */
    public static short getShort(byte[] bytes) {
        return (short) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
    }

    /**
     * bytes to char
     */
    public static char getChar(byte[] bytes) {
        return (char) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
    }



    /**
     * bytes to long
     */
    public static long getLong_LE(byte[] bytes) {
        return (0xffL & (long) bytes[0]) | (0xff00L & ((long) bytes[1] << 8)) | (0xff0000L & ((long) bytes[2] << 16))
                | (0xff000000L & ((long) bytes[3] << 24)) | (0xff00000000L & ((long) bytes[4] << 32))
                | (0xff0000000000L & ((long) bytes[5] << 40)) | (0xff000000000000L & ((long) bytes[6] << 48))
                | (0xff00000000000000L & ((long) bytes[7] << 56));
    }
    public static long getLong_BE(byte[] bytes) {
        return (0xffL & (long) bytes[7]) | (0xff00L & ((long) bytes[6] << 8)) | (0xff0000L & ((long) bytes[5] << 16))
                | (0xff000000L & ((long) bytes[4] << 24)) | (0xff00000000L & ((long) bytes[3] << 32))
                | (0xff0000000000L & ((long) bytes[2] << 40)) | (0xff000000000000L & ((long) bytes[1] << 48))
                | (0xff00000000000000L & ((long) bytes[0] << 56));
    }

    /**
     * bytes to float
     */
    public static float getFloat(byte[] bytes) {
        return Float.intBitsToFloat(Bytes2Int_LE(bytes));
    }

    /**
     * bytes to double
     */
    public static double getDouble_LE(byte[] bytes) {
        long l = getLong_LE(bytes);
        return Double.longBitsToDouble(l);
    }

    /**
     * bytes to string
     */
    public static String getString(byte[] bytes, String charsetName) {
        return new String(bytes, Charset.forName(charsetName));
    }

    /**
     * bytes to string
     */
    public static String getString(byte[] bytes) {
        return getString(bytes, "GBK");
    }

    public static void main(String[] a) {
        Integer abc = 100;

        byte[] bytes = HexStringCovert.hexStringToByte("00800000000976AA");
        byte[] bytes2 = HexStringCovert.hexStringToByte("0080000000000000");
        for (int i = 0; i < bytes.length; i++) {
            //System.out.println(bytes[i]);
        }

        System.out.println("Adata小端="+getLong_LE(bytes));
        System.out.println("Adata大端="+getLong_BE(bytes));
        System.out.println("offst小端="+getLong_LE(bytes2));
        System.out.println("offst大端="+getLong_BE(bytes2));
        long offst = getLong_LE(bytes2);
        long adata = getLong_LE(bytes);
        long bdata = 0;
        if(adata>offst){
            bdata = adata - offst;
            System.out.println("Bdata="+bdata);
        }else{
            bdata = offst - adata;
            System.out.println("Bdata="+bdata);
            //TODO: 见C语言处理
            bdata = - bdata;
        }
        long f = bdata*offst;
        System.out.println("f="+f);
    }
}
