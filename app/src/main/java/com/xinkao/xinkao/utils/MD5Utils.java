package com.xinkao.xinkao.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密方式
 *
 * Create by 钱 on 2018/9/29 0029.
 */
public class MD5Utils {
    public static String encrypt(String password) {
        try {
            //选择加密方式
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //加密数据转字节流
            byte[] bytes = digest.digest(password.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes
                    ) {
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            String MD5 = stringBuffer.toString();
            return MD5;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
