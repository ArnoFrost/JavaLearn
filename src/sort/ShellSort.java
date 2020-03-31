package sort;

import utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2020/3/28 10:54
 * @Version 1.0
 */
public class ShellSort {

    public static void shellSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("ShellSort.shellSort");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");

        int length = a.length;
        int grepNum = 2;
        //进行分组,步长为grepNum
        for (int gap = length / grepNum; gap > 0; gap /= grepNum) {
            for (int i = gap; i < length; i++) {
                insertI(a, gap, i);
            }
        }
        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();

    }

    private static void insertI(int[] a, int gap, int i) {
//        System.out.println("ShellSort.insertI");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        int inserted = a[i];
        int j;
        for (j = i - gap; j >= 0 && inserted < a[j]; j -= gap) {
            a[j + gap] = a[i];
        }
        a[j + gap] = inserted;
    }
}
