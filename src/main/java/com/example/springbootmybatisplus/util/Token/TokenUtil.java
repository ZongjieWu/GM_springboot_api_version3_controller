package com.example.springbootmybatisplus.util.Token;



import com.example.springbootmybatisplus.util.AESUtil;
import com.example.springbootmybatisplus.util.MD5Util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hjh
 * @version 1.0
 * @date 2019/10/21
 */
public class TokenUtil {

    /**
     * token密钥
     */
    private static final String TOKEN_AES_KEY = "455ad65w2cxaq";
    /**
     * 有效期1天
     */
    private static final Long TOKEN_OVER_TIME = 1000L * 60L * 60L * 24L;

    /**
     * 生成token
     * @param userTokenDto
     * @return
     */
    public static String createToken(UserTokenDto userTokenDto) {
        String token = null;

        if (userTokenDto.getId() != null && userTokenDto.getType() != null && userTokenDto.getDepartmentId() != null) {
            Long timestamp = System.currentTimeMillis();
            // userId type departmentId time  四个关键字段生成token
            String data = userTokenDto.getId() + "|" + userTokenDto.getType() + "|" + userTokenDto.getDepartmentId() + "|" + timestamp;

            // 生成md5校验数据是否被篡改
            String key = data + "-" + MD5Util.getMD5(data);

            token = AESUtil.encode(key, TokenUtil.TOKEN_AES_KEY);
        }

        return token;
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public static UserTokenDto decodeToken(String token) {
        UserTokenDto userTokenDto = null;
        if (Is.isNoEmpty(token)) {
            String key = AESUtil.decode(token, TokenUtil.TOKEN_AES_KEY);
            String[] keyVals = key.split("-");
            if (Is.isNoEmpty(keyVals) && keyVals.length == 2) {
                // 获取加密字符串和源数据
                String md5 = keyVals[1];
                String[] datas = keyVals[0].toString().split("\\|");
                if (datas.length == 4) {
                    // 解析源数据
                    Long userId = Long.valueOf(datas[0]);
                    Integer type = Integer.valueOf(datas[1]);
                    Long departmentId = Long.valueOf(datas[2]);
                    Long timestamp = Long.valueOf(datas[3]);

                    // 校验md5对不对
                    String data = userId + "|" + type + "|" + departmentId + "|" + timestamp;
                    if (Is.isNoEmpty(md5) && md5.equals(MD5Util.getMD5(data))) {
                        // 校验时间有没过期
                        Long bTime = System.currentTimeMillis() - timestamp;
                        if (bTime < TokenUtil.TOKEN_OVER_TIME) {
                            // 没过期
                            userTokenDto = new UserTokenDto(userId, type, departmentId);
                        }
                    }
                }
            }
        }
        return userTokenDto;
    }

    /**
     * 从请求头里获取token
     * @param request
     * @return
     */
    public static UserTokenDto get(HttpServletRequest request) {
        return decodeToken(request.getHeader("token"));
    }
}
