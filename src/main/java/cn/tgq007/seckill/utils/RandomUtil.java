package cn.tgq007.seckill.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    public static final String BASE_NUMBER = "0123456789";
    public static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
    public static final String EMPTY = "";

    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }

    public static int randomInt(int origin, int bound) {
        return getRandom().nextInt(origin, bound);
    }

    public static int randomInt(int bound) {
        return getRandom().nextInt(bound);
    }

    public static int randomInt() {
        return getRandom().nextInt();
    }

    public static final String BASE_CHAR_NUMBER = BASE_CHAR + BASE_NUMBER;

    public static String randomString(String baseString, int length) {
        if (StringUtils.isEmpty(baseString))
            return EMPTY;
        if (length < 1)
            length = 1;
        final StringBuilder stringBuilder = new StringBuilder(length);
        int baseLength = baseString.length();
        for (int i = 0; i < length; i++) {
            int index = randomInt(baseLength);
            stringBuilder.append(baseString.charAt(index));
        }
        return stringBuilder.toString();
    }

    public static String randomString(int length) {
        return randomString(BASE_CHAR_NUMBER, length);
    }
}
