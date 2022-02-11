package team.sun.integration.protocol.hex.utils;

public class HexStringCovert {

    /**
     * 截取数组并顺序排列
     */
    public static byte[] arraySub(byte[] data, int index, int length) {
        byte[] bytes = new byte[length];
        int j = 0;
        for (int i = index; i < index+length; i++) {
            bytes[j] = data[i];
            j++;
        }
        return bytes;//返回截取数组的地址
    }

    /**
     * 截取数组并倒序排列
     */
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

    public static String bytesToHexWordString(byte[] byte_array) {
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

    public static String bytesToBinaryString(byte[] byte_array) {
        byte tByte;
        StringBuilder stringBuilder = new StringBuilder();
        if (null != byte_array && byte_array.length > 0) {
            for (byte b : byte_array) {
                tByte = b;
                stringBuilder.append(
                        Integer.toBinaryString(
                                (tByte & 0xFF) + 0x100).substring(1));
            }
        }
        return stringBuilder.toString();
    }

}
