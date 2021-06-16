package team.sun.integration.protocol.hex.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.Charset;

public class BasicTypeCovert {

    /**
     * int转换为小端byte[]（高位放在高地址中）
     *
     * @param iValue 整数
     * @return 字节数组
     */
    @NotNull
    @Contract(pure = true)
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
     * int转换为小端byte[]（高位放在高地址中）
     *
     * @param iValue 整数
     * @param digit  字节个数
     * @return 字节数组
     */
    @NotNull
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
     * int转换为大端byte[]（高位放在高地址中）
     *
     * @param iValue 整数
     * @return 字节数组
     */
    @NotNull
    @Contract(pure = true)
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
     * int转换为大端byte[]（高位放在高地址中）
     *
     * @param iValue 整数
     * @param digit  字节个数
     * @return 字节数组
     */
    @NotNull
    @Contract(pure = true)
    public static byte[] Int2Bytes_BE_digit(int iValue, int digit) {
        byte[] rst = new byte[digit];
        if (digit > 3) {
            // 先写int的最后一个字节
            rst[3] = (byte) (iValue & 0xFF);
        }
        if (digit > 2) {
            // int 倒数第二个字节
            rst[2] = (byte) ((iValue & 0xFF00) >> 8);
        }
        if (digit > 1) {
            // int 倒数第三个字节
            rst[1] = (byte) ((iValue & 0xFF0000) >> 16);
        }
        if (digit > 0) {
            // int 第一个字节
            rst[0] = (byte) ((iValue & 0xFF000000) >> 24);
        }
        return rst;
    }

    /**
     * int(小端)
     *
     * @param bytes
     * @return
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
     *
     * @param bytes
     * @return
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
     *
     * @param data
     * @return
     */
    public static byte[] getBytes(short data) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data & 0xff00) >> 8);
        return bytes;
    }

    /**
     * char to byte[]
     *
     * @param data
     * @return
     */
    public static byte[] getBytes(char data) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data);
        bytes[1] = (byte) (data >> 8);
        return bytes;
    }

    /**
     * int to byte[]
     *
     * @param data
     * @return
     */
    public static byte[] getBytes(int data) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data & 0xff00) >> 8);
        bytes[2] = (byte) ((data & 0xff0000) >> 16);
        bytes[3] = (byte) ((data & 0xff000000) >> 24);
        return bytes;
    }

    public static byte[] getBytes1(int data) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) (data >> 8 & 0xff);
        bytes[2] = (byte) (data >> 16 & 0xff);
        bytes[3] = (byte) (data >> 24 & 0xff);
        return bytes;
    }

    /**
     * long to byte[]
     *
     * @param data
     * @return
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
     *
     * @param data
     * @return
     */
    public static byte[] getBytes(float data) {
        int intBits = Float.floatToIntBits(data);
        return getBytes(intBits);
    }

    /**
     * double to byte[]
     *
     * @param data
     * @return
     */
    public static byte[] getBytes(double data) {
        long intBits = Double.doubleToLongBits(data);
        return getBytes(intBits);
    }

    /**
     * String to byte[]
     *
     * @param data
     * @param charsetName
     * @return
     */
    public static byte[] getBytes(String data, String charsetName) {
        Charset charset = Charset.forName(charsetName);
        return data.getBytes(charset);
    }

    /**
     * String to byte[]
     *
     * @param data
     * @return
     */
    public static byte[] getBytes(String data) {
        return getBytes(data, "GBK");
    }

    /**
     * bytes to short
     *
     * @param bytes
     * @return
     */
    public static short getShort(byte[] bytes) {
        return (short) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
    }

    /**
     * bytes to char
     *
     * @param bytes
     * @return
     */
    public static char getChar(byte[] bytes) {
        return (char) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
    }

    /**
     * bytes to int
     *
     * @param bytes
     * @return
     */
    public static int getInt(byte[] bytes) {
        return (0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)) | (0xff0000 & (bytes[2] << 16))
                | (0xff000000 & (bytes[3] << 24));
    }


    /**
     * bytes to long
     *
     * @param bytes
     * @return
     */
    public static long getLong(byte[] bytes) {
        return (0xffL & (long) bytes[0]) | (0xff00L & ((long) bytes[1] << 8)) | (0xff0000L & ((long) bytes[2] << 16))
                | (0xff000000L & ((long) bytes[3] << 24)) | (0xff00000000L & ((long) bytes[4] << 32))
                | (0xff0000000000L & ((long) bytes[5] << 40)) | (0xff000000000000L & ((long) bytes[6] << 48))
                | (0xff00000000000000L & ((long) bytes[7] << 56));
    }

    /**
     * bytes to float
     *
     * @param bytes
     * @return
     */
    public static float getFloat(byte[] bytes) {
        return Float.intBitsToFloat(getInt(bytes));
    }

    /**
     * bytes to double
     *
     * @param bytes
     * @return
     */
    public static double getDouble(byte[] bytes) {
        long l = getLong(bytes);
        System.out.println(l);
        return Double.longBitsToDouble(l);
    }

    /**
     * bytes to string
     *
     * @param bytes
     * @param charsetName
     * @return
     */
    public static String getString(byte[] bytes, String charsetName) {
        return new String(bytes, Charset.forName(charsetName));
    }

    /**
     * bytes to string
     *
     * @param bytes
     * @return
     */
    public static String getString(byte[] bytes) {
        return getString(bytes, "GBK");
    }

    public static void main(String[] a) {
        System.out.println(HexStringCovert.bytesToHexString(Int2Bytes_LE_digit(2202, 1)));
        System.out.println(Bytes2Int_LE(Int2Bytes_LE_digit(2202, 1)));
        System.out.println(Bytes2Int_BE(Int2Bytes_BE(2202)));
    }
}
