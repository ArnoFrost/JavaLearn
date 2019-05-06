package sort;

import utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:30
 * @Version 1.0
 */
public class InsertionSort {

    public static void insertionSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("InsertionSort.insertionSort");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
        TestUtils.printCostTime();
        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
    }
}
