package cn.tgq007.seckill.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static String getSalt(int length) {
        return RandomUtil.randomString(length);
    }

    public static String encoderPassword(String password, String salt) {
        String newPassword = salt.charAt(0) + salt.charAt(5) + password + salt.charAt(2) + salt.charAt(2);
        return DigestUtils.md5Hex(newPassword);
    }
}
