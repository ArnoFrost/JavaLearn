package sort;

import utils.ArrayUtils;
import utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-07 14:23
 * @Version 1.0
 */
public class QuickSort2Ways {
    public static void quickSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("QuickSort2Ways.quickSortInternally");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");

        quickSortInternally(a, 0, a.length - 1);

        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();
    }

    private static void quickSortInternally(int[] a, int lIndex, int rIndex) {
        if (lIndex >= rIndex) {
            return;
        }
        //优化 当数组元素小于等于15时 用插入排序来进行
//        int minSize = 15;
//        if (rIndex - lIndex <= minSize) {
//            insertionSort(a, lIndex, rIndex);
//            return;
//        }

        //优化: 随机基元来尽量避免退化成O(n²)级别的算法
        ArrayUtils.swapArray(a, TestUtils.getRandomNumber(lIndex, rIndex), lIndex);
        //核心步骤
        int partitionIndex = partition(a, lIndex, rIndex);
        //获取分区点 递归方式 划分
        // [l..partitionIndex-1]
        quickSortInternally(a, lIndex, partitionIndex - 1);
        //[partitionIndex+1..right]
        quickSortInternally(a, partitionIndex + 1, rIndex);
    }

    /**
     * 双路快排实现
     *
     * @param arr
     * @param lIndex
     * @param rIndex
     * @return
     */
    private static int partition(int[] arr, int lIndex, int rIndex) {
        //将基元值设置为一个数值 比如第一个
        int pivot = arr[lIndex];

        //arr[lIndex..i) <=v
        //arr(j..rIndex) >=v

        //标识出两个索引 i, j
        int i = lIndex + 1;
        int j = rIndex;
        while (true) {
            while (i <= rIndex && arr[i] < pivot) {
                i++;
            }
            while (j >= lIndex + 1 && arr[j] > pivot) {
                j--;
            }
            if (i > j) {
                break;
            }
            ArrayUtils.swapArray(arr, i++, j--);
        }
        ArrayUtils.swapArray(arr, lIndex, j);

        return j;
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
