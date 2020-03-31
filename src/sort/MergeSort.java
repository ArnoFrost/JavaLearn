package sort;

import utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-07 11:28
 * @Version 1.0
 */
public class MergeSort {

    public static void mergeSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("MergeSort.mergeSort");
        if (a == null || a.length == 1) {
            System.out.println("array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");
        mergeSortInternally(a, 0, a.length - 1);
        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();
    }

    /**
     * 递归调用函数
     *
     * @param a
     * @param left
     * @param right
     */
    private static void mergeSortInternally(int[] a, int left, int right) {
        // 递归终止条件
        if (left >= right) {
            return;
        }

        // 取left到right之间的中间位置middle,防止（left+right）的和超过int类型最大值
        int middle = left + (right - left) / 2;
        // 分治递归
        mergeSortInternally(a, left, middle);
        mergeSortInternally(a, middle + 1, right);

        // 将A[left...middle]和A[middle+1...right]合并为A[left...right]
        merge(a, left, middle, right);
    }

    /**
     * 合并数组
     *
     * @param a
     * @param left   左边界
     * @param middle 中间值
     * @param right  右边界
     */
    private static void merge(int[] a, int left, int middle, int right) {
        /**
         * 初始化变量lIndex,rIndex,middle
         */
        int lIndex = left;
        int rIndex = middle + 1;
        int mergeIndex = 0;
        /**
         * 申请一个大小跟a[left...right]一样的临时数组
         */
        int[] tmp = new int[right - left + 1];
        while (lIndex <= middle && rIndex <= right) {
            if (a[lIndex] <= a[rIndex]) {
                tmp[mergeIndex++] = a[lIndex++];
            } else {
                tmp[mergeIndex++] = a[rIndex++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start, end;
        //右边有剩余 rIndex .. right
        if (rIndex <= right) {
            start = rIndex;
            end = right;
        } else {
            //左边有剩余 lIndex .. middle
            start = lIndex;
            end = middle;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[mergeIndex++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[left...right]
        for (lIndex = 0; lIndex <= right - left; ++lIndex) {
            //拷贝数组有left的偏移
            a[left + lIndex] = tmp[lIndex];
        }
    }

}
