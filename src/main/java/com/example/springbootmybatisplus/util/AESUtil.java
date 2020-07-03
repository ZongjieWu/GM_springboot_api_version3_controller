package com.example.springbootmybatisplus.util;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 进制转换、安全加密工具
 *
 * @author
 */
public class AESUtil {

    /**
     * 将16进制转换为二进制
     */
    public static byte[] parseHexStr2Byte(String hexStr) {

        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        int tmp = hexStr.length() / 2;
        for (int i = 0; i < tmp; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf byte[]
     * @return 字符串
     */

    public static String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return 加密后
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = content.getBytes(StandardCharsets.UTF_8);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength
                        + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8),
                    "AES");
            IvParameterSpec ivspec = new IvParameterSpec(password.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return parseByte2HexStr(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 加密
     *
     * @param content
     *            需要加密的内容
     * @param password
     *            加密密码
     * @return
     */
    private static byte[] encrypt2(String content, String password) {
        byte[] result = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES");
            byte[] byteContent = content.getBytes("utf-8");
            // 初始化
            cipher.init(Cipher.ENCRYPT_MODE, key);
            result = cipher.doFinal(byteContent);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解密
     *
     * @param content
     *            待解密内容
     * @param password
     *            解密密钥
     * @return
     */
    private static byte[] decrypt2(byte[] content, String password) {
        byte[] result = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(content);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param key 密钥
     * @return
     */
    public static String encode(String content, String key) {
        return AESUtil.parseByte2HexStr(AESUtil.encrypt2(content, key));
    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @param key 密钥
     * @return
     */
    public static String decode(String content, String key) {
        return new String(AESUtil.decrypt2(AESUtil.parseHexStr2Byte(content), key));
    }

    /**
     * 随机生成16为大小写字母+数字
     *
     * @return String
     */
    public static String getCharAndNumr() {
        int length = 16;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                sb.append((char) (choice + random.nextInt(26)));
            } else {
                // 数字
                sb.append(String.valueOf(random.nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static String md5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes(StandardCharsets.UTF_8));
            byte[] b = md.digest();
            int i;
            StringBuilder buf = new StringBuilder();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getTradeNo() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + (int) (Math.random() * (1000 - 100) + 100);
    }

}
