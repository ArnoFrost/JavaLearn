package algo.sort.needfix;

import datastruct.utils.ArrayUtils;
import datastruct.utils.TestUtils;

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
            System.out.println("datastruct.array is null or length is only 1");
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

    private static int partition(int[] arr, int lIndex, int rIndex) {
        //将基元值设置为一个数值 比如第一个
        int pivot = arr[lIndex];
        //定义规则 让arr[lIndex+1..partitionIndex] < pivot
        // arr[partitionIndex+1..i) > pivot 前闭后开注意

        //※※※初始化的时候 第一个数组区间为空 因为 partitionIndex = lIndex 相当于[lIndex + 1.. lIndex] 区间不存在
        int partitionIndex = lIndex;

        //※※※且由于i = lIndex + 1 [partitionIndex+1 ..i) ≈ [lIndex + 1 .. lIndex + 1) 区间也为空
        for (int i = lIndex + 1; i <= rIndex; i++) {
            //∵要始终满足arr[partitionIndex+1 ..i] > pivot
            //∴如果当前考察元素 大于 基准pivot 不需要做事情
//            if (arr[i] > pivot) {
//
//            }

            //∵不满足定义所以要放置到之前的arr[lIndex+1..partitionIndex]区间中
            //将小于基准的元素 交换并继续遍历考察满足的情况
            if (arr[i] < pivot) {
                ArrayUtils.swapArray(arr, ++partitionIndex, i);
            }
        }

        //最后将基元的位置放入应该放入的位置
        //也就是partitionIndex,此时 数据满足 [lIndex..partition] < pivot > [partition+1 ..rIndex]
        //至此结束此次partition操作
        ArrayUtils.swapArray(arr, partitionIndex, lIndex);

        return partitionIndex;
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
