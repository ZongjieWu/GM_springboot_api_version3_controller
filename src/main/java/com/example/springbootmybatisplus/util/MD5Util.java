package com.example.springbootmybatisplus.util;

import java.security.MessageDigest;

/**
 * md5工具类
 *
 * @author hjh
 */
public class MD5Util {

    /**
     * 生成md5
     *
     * @param message
     * @return
     */
    public static String getMD5(String message) {
        String md5str = "";
        try {
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 2 将消息变成byte数组
            byte[] input = message.getBytes("utf-8");
            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);
            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    /**
     * 生成MD5
     * @param byteFile
     * @return
     */
    public static String getMD5Str(byte[] byteFile) {
        String md5str = "";
        try {
//            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(byteFile);
            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

    //信息摘要算法
    public static String stdMD5Code(String message) {
        String md5Str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(message.getBytes());
            md5Str = bytes2Hex(md5Bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str;
    }

    // 2进制转16进制
    public static String bytes2Hex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        int temp;
        try {
            for (int i = 0; i < bytes.length; i++) {
                temp = bytes[i];
                if (temp < 0) {
                    temp += 256;
                }
                if (temp < 16) {
                    result.append("0");
                }
                result.append(Integer.toHexString(temp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
