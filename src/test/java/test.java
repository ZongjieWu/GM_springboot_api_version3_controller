import com.example.springbootmybatisplus.util.MD5Util;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class test {
    public static void main(String[] args) {
        String str="name=小李&phone=15979856881&pwd=123456&saasUserRoleId=1";
        Long ss=System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
        String nonce=UUID.randomUUID().toString().replace("-","").toLowerCase();
        System.out.println(nonce);
        str+="&timestamp="+ss+"&nonce="+nonce;
        str+="&appKey=98D2B646B2DE022DC7EC07866DE06699";
        System.out.println(str);
        String sign= MD5Util.getMD5(str).toUpperCase();
        System.out.println(sign);
        String requestParamStr=str+"&sign="+sign+"";
        String[] aa=requestParamStr.split("&");
        Arrays.asList(aa).forEach((a)-> System.out.println(a));
    }
}
