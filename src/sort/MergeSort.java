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
     * @param p
     * @param r
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * 合并数组
     *
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] a, int p, int q, int r) {
        /**
         * 初始化变量i, j, k
         */
        int pIndex = p;
        int rIndex = q + 1;
        int mergeIndex = 0;
        /**
         * 申请一个大小跟a[p...r]一样的临时数组
         */
        int[] tmp = new int[r - p + 1];
        while (pIndex <= q && rIndex <= r) {
            if (a[pIndex] <= a[rIndex]) {
                // i++等于i:=i+1
                tmp[mergeIndex++] = a[pIndex++];
            } else {
                tmp[mergeIndex++] = a[rIndex++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = pIndex;
        int end = q;
        if (rIndex <= r) {
            start = rIndex;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[mergeIndex++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (pIndex = 0; pIndex <= r - p; ++pIndex) {
            a[p + pIndex] = tmp[pIndex];
        }
    }

}
