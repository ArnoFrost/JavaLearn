package algo.sort.needfix;

import datastruct.utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-07 11:28
 * @Version 1.0
 */
public class MergeSort {

    /**
     * 自顶向下归并
     *
     * @param a
     */
    public static void mergeSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("MergeSort.mergeSort");
        if (a == null || a.length == 1) {
            System.out.println("datastruct.array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");
        mergeSortInternally(a, 0, a.length - 1);
        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();
    }

    /**
     * 递归调用函数 对arr[left..right) 前闭后开区间
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
        mergeSortInternally(a, 0, middle);
        mergeSortInternally(a, middle + 1, right);

        //优化改进,看是否需要继续合并,优化近乎有序情况 左边已经都小于右边
        if (a[middle] > a[middle + 1]) {
            // 将A[left...middle]和A[middle+1...right]合并为A[left...right]
            merge(a, left, middle, right);
        }

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

    /**
     * 自底向上归并 bottomUp 待整理
     *
     * @param a
     */
    public static void mergeSortBU(int[] a) {
        int length = a.length;
        for (int sz = 1; sz <= length; sz += sz) {
            for (int i = 0; i + sz < length; i += sz + sz) {
                merge(a, i, i + sz - 1, Math.min(i + sz + sz - 1, length - 1));
            }
        }
    }

}
