package utils;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:43
 * @Version 1.0
 * 数组辅助生成类
 */
public class ArrayUtils {
    public static int[] getRadomArray(int length) {
        return getRadomArray(length, 1, 10);
    }

    /**
     * 生成简单的数组 带有区间
     *
     * @param length
     * @param min
     * @param max
     * @return
     */
    public static int[] getRadomArray(int length, int min, int max) {
        if (length < 0) {
            return null;
        }
        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = TestUtils.getRadomNumber(min, max);
        }

        return a;
    }

    /**
     * 生成有序数组
     *
     * @param length
     * @return
     */
    public static int[] getOrderArray(int length) {
        if (length < 0) {
            return null;
        }
        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = i;
        }

        return a;
    }

    public static int[] getNearlyOrderArray(int length, int n) {
        return getNearlyOrderArray(length, n, 1, 10);
    }

    /**
     * 生成近乎有序的数组
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

    public static int[] getBadArray(int length) {
        return getBadArray(length, 1, length);
    }

    /**
     * 生成反序数组
     *
     * @param length
     * @param min
     * @param max
     * @return
     */
    public static int[] getBadArray(int length, int min, int max) {
        if (length < 0) {
            return null;
        }
        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = length - i;
        }
        return a;
    }

    /**
     * 交换数组
     *
     * @param a
     * @param i
     * @param j
     * @return
     */
    public static int[] swapArray(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        return a;
    }
}
