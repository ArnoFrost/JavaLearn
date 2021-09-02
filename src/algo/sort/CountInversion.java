package algo.sort;

import datastruct.utils.ArrayUtils;
import datastruct.utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/6 13:46
 * @Version 1.0
 */
public class CountInversion {
    //求一个数组中逆序对

    /**
     * 随机数组 注意:避免原地排序浅拷贝带来的问题
     */

    private static final int ARRAY_LENGTH = 1000;

    private static int[] randomArray = ArrayUtils.getBadArray(ARRAY_LENGTH);

    public static void main(String[] args) {

        int number = getReverseNumber(randomArray);
        System.out.println("number = " + number);
    }

    private static int getReverseNumber(int[] array) {
        TestUtils.printStartTime();
        System.out.println("MergeSort.mergeSort");
        if (array == null || array.length == 1) {
            System.out.println("datastruct.array is null or length is only 1");
            return 0;
        }
        System.out.println("before sort a = [" + Arrays.toString(array) + "]");
        //合并记录
        int number = 0;
        number += mergeInternally(array, 0, array.length - 1);
        System.out.println("after sort a = [" + Arrays.toString(array) + "]");
        TestUtils.printCostTime();
        return number;
    }

    private static int mergeInternally(int[] randomArray, int lIndex, int rIndex) {
        if (lIndex >= rIndex) {
            return 0;
        }
        // 取left到right之间的中间位置middle,防止（left+right）的和超过int类型最大值
        int middle = lIndex + (rIndex - lIndex) / 2;

        mergeInternally(randomArray, lIndex, middle);
        mergeInternally(randomArray, middle + 1, rIndex);

        if (randomArray[middle] > randomArray[middle + 1]) {
            return merge(randomArray, lIndex, rIndex, middle);
        }
        return 0;
    }

    private static int merge(int[] array, int left, int right, int middle) {
        /**
         * 初始化变量lIndex,rIndex,middle
         */
        int lIndex = left;
        int rIndex = middle + 1;
        int mergeIndex = 0;
        int count = 0;
        /**
         * 申请一个大小跟a[left...right]一样的临时数组
         */
        int[] tmp = new int[right - left + 1];
        while (lIndex <= middle && rIndex <= right) {
            if (array[lIndex] <= array[rIndex]) {
                tmp[mergeIndex++] = array[lIndex++];
            } else {
                //记录逆序对
                count += middle - lIndex + 1;
                tmp[mergeIndex++] = array[rIndex++];
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
            tmp[mergeIndex++] = array[start++];
        }

        // 将tmp中的数组拷贝回a[left...right]
        for (lIndex = 0; lIndex <= right - left; ++lIndex) {
            //拷贝数组有left的偏移
            array[left + lIndex] = tmp[lIndex];
        }

        return count;
    }

}
