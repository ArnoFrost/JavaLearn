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
        int length = a.length;
        int sortTimes = 1;
        //原始写法
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
                sortTimes++;
            }
        }
        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        System.out.println("sortTimes = " + sortTimes);
        TestUtils.printCostTime();
    }

    public static void bubbleSortOpt(int[] a) {
        TestUtils.printStartTime();
        System.out.println("BubbleSort.bubbleSortOpt");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");
        //1. 优化写法 减少遍历
//        int n = a.length;
//        boolean swapped = false;
//        do {
//            swapped = false;
//            for (int i = 1; i < n; i++) {
//                if (a[i - 1] > a[i]) {
//                    int temp = a[i - 1];
//                    a[i - 1] = a[i];
//                    a[i] = temp;
//
//                    swapped = true;
//                }
//            }
//            //优化点: 每一趟都将最大元素放在了最后的位置
//            //下一次排序,最后的元素可不考虑
//            n--;
//        } while (swapped);

        //2. 优化写法
        int n = a.length;
        int newn;//通过newn优化

        int sortTimes = 1;
        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    int temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;

                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
                sortTimes++;
            }
            n = newn;
//            System.out.println("sort a by [" + sortTimes "] times = [" + Arrays.toString(a) + "]");
        } while (newn > 0);


        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        System.out.println("sortTimes = " + sortTimes);

        TestUtils.printCostTime();
    }

    private static int[] swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }
}
