package sort;

import utils.ArrayUtils;
import utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-07 14:23
 * @Version 1.0
 */
public class QuickSort {
    public static void quickSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("QuickSort.quickSortInternally");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");

        quickSortInternally(a, 0, a.length - 1);

        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();
    }

    private static void quickSortInternally(int[] a, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        //随机基元来尽量避免退化成O(n²)级别的算法
        ArrayUtils.swapArray(a, TestUtils.getRadomNumber(leftIndex, rightIndex), leftIndex);
        //获取分区点
        int partitionIndex = partition(a, leftIndex, rightIndex);
        quickSortInternally(a, leftIndex, partitionIndex - 1);
        quickSortInternally(a, partitionIndex + 1, rightIndex);
    }

    private static int partition(int[] a, int leftIndex, int rightIndex) {

        int pivot = a[rightIndex];
        int partitionIndex = leftIndex;

//        System.out.println("test partition begin = ");
//        for (int i = leftIndex; i <= rightIndex; i++) {
//            System.out.print(a[i] + ",");
//            if (i == rightIndex) {
//                System.out.println("test partition end = ");
//            }
//        }

        for (int i = leftIndex; i < rightIndex; i++) {
            if (a[i] < pivot) {
                if (partitionIndex == i) {
                    partitionIndex++;
                } else {
                    ArrayUtils.swapArray(a, partitionIndex, i);
                    partitionIndex++;
                }
            }
        }
        ArrayUtils.swapArray(a, partitionIndex, rightIndex);


//        System.out.println("partition Index = " + partitionIndex);
//        System.out.println("array = " + Arrays.toString(a));

        return partitionIndex;
    }


}
