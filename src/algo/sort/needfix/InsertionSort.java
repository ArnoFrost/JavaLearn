package algo.sort.needfix;

import datastruct.utils.TestUtils;

import java.util.Arrays;

/**
 * @Author: ArnoFrost 选择排序(可提前结束,减少交换开销优化)
 * @Date: 2019-05-06 20:30
 * @Version 1.0
 */
public class InsertionSort {

    public static void insertionSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println("InsertionSort.insertionSort");
        if (a == null || a.length == 1) {
            System.out.println("datastruct.array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");
        int length = a.length;
        for (int i = 1; i < length; i++) {
            //复制保存
            int value = a[i];
            //改进 减少交换
            int j = i - 1;
            for (; j >= 0; j--) {
                //后一个元素比前一个大
                if (a[j] > value) {
                    //触发向后赋值
                    a[j + 1] = a[j];
                } else {//提前终止循环
                    break;
                }
            }
            //保存索引后再去赋值
            a[j + 1] = value;
        }
        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();
    }
}
