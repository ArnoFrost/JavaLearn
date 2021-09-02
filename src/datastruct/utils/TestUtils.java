package datastruct.utils;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:38
 * @Version 1.0
 * 辅助测试工具类
 */
public class TestUtils {

    private static long time = 0;

    public TestUtils() {
    }

    public static void printStartTime() {
        TestUtils.time = System.currentTimeMillis();
//        System.out.println("start time = " + time);
    }

    public static void printCostTime() {
        TestUtils.time = System.currentTimeMillis() - TestUtils.time;
        System.out.println("cost time = " + time);
    }

    /**
     * 返回一个指定区间的随机数
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    // 判断一个字符串是否为数字型
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        String json = "";
        return pattern.matcher(str).matches();
    }

}
