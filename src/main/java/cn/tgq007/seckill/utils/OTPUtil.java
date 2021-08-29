package cn.tgq007.seckill.utils;

public class OTPUtil {

    public static String generateOTP(int min, int max) {
        return String.valueOf(RandomUtil.randomInt(min, max));
    }
}
