package utils;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:43
 * @Version 1.0
 */
public class ArrayUtils {
    /**
     * 生成一个简单的数组
     *
     * @param length
     * @return
     */
    public static int[] getSimpleArray(int length) {
        return getSimpleArray(length, 1, 10);
    }

    /**
     * 生成一个简单的数组 带有区间
     *
     * @param length
     * @param min
     * @param max
     * @return
     */
    public static int[] getSimpleArray(int length, int min, int max) {
        if (length < 0) {
            return null;
        }
        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = TestUtils.getRadomNumber(min, max);
        }

        return a;
    }

    public static int[] getNearlyOrderArray(int length, int n) {
        return getNearlyOrderArray(length, n, 1, 10);
    }

    /**
     * 生成一个近乎有序的数组
     *
     * @param length
     * @param n      非有序个数
     * @param min
     * @param max
     * @return
     */
    public static int[] getNearlyOrderArray(int length, int n, int min, int max) {
        if (length < 0) {
            return null;
        }
        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = i;
        }

        for (int i = 0; i < n; i++) {
            a[TestUtils.getRadomNumber(0, length - 1)] = TestUtils.getRadomNumber(min, max);
        }

        return a;
    }
}
