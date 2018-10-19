package com.example.admin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Encrypt {
    /**
     * 不可逆加密
     * @param str 明文
     * @return 密文
     */
    public static String turnMesssage(String str) {
        if (str.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("SHA");
            md5.update(str.getBytes());
            for (byte b : md5.digest()) {
                stringBuilder.append(String.format("%02X", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
