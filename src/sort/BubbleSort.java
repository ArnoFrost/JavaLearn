package sort;

import utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-07 10:14
 * @Version 1.0
 */
public class BubbleSort {

    public static void bubbleSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("BubbleSort.bubbleSort");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();
    }
}
