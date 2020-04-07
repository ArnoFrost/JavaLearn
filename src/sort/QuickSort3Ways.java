package sort;

import utils.ArrayUtils;
import utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-07 14:23
 * @Version 1.0
 */
public class QuickSort3Ways {
    public static void quickSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("QuickSort3Ways.quickSortInternally");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");

        quickSortInternally(a, 0, a.length - 1);

        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();
    }

    /**
     * 三路快排实现
     *
     * @param arr
     * @param lIndex
     * @param rIndex
     * @return
     */
    private static void quickSortInternally(int[] arr, int lIndex, int rIndex) {
        if (lIndex >= rIndex) {
            return;
        }
        //优化 当数组元素小于等于15时 用插入排序来进行
//        int minSize = 15;
//        if (rIndex - lIndex <= minSize) {
//            insertionSort(a, lIndex, rIndex);
//            return;
//        }

        //partition
        //优化: 随机基元来尽量避免退化成O(n²)级别的算法
        ArrayUtils.swapArray(arr, TestUtils.getRandomNumber(lIndex, rIndex), lIndex);

        //核心步骤
        int v = arr[lIndex];
        int lt = lIndex;//arr[l+1..lt] < v
        int gt = rIndex + 1; //arr[gt..r] > v
        int i = lIndex + 1;//arr[lt+1..i] = v

        while (i < gt) {
            if (arr[i] < v) {
                ArrayUtils.swapArray(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > v) {
                ArrayUtils.swapArray(arr, i, gt - 1);
                gt--;
            } else {
                //=v
                i++;
            }
        }

        ArrayUtils.swapArray(arr, lIndex, lt);
        quickSortInternally(arr, lIndex, lt - 1);
        quickSortInternally(arr, gt, rIndex);
    }

    private static void insertionSort(int[] a, int lIndex, int rIndex) {
        if (a == null || a.length == 1) {
            return;
        }

        int length = a.length;
        for (int i = 0; i < length; i++) {
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
    }

}
