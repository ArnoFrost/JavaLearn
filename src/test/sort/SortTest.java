package test.sort;

import sort.*;
import utils.ArrayUtils;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:35
 * @Version 1.0
 */
public class SortTest {
    /**
     * 数组长度
     */
    private static int ARRAY_LENGTH = 5;
    /**
     * 有序数字个数
     */
    private static int ORDER_LENGTH = 100;

    /**
     * 随机数组 注意:避免原地排序浅拷贝带来的问题
     */

    private static int[] randomArray = ArrayUtils.getRandomArray(ARRAY_LENGTH);

    /**
     * 近乎有序数组
     */
    private static int[] nearlyOrderArray = ArrayUtils.getNearlyOrderArray(ARRAY_LENGTH, ORDER_LENGTH);
    /**
     * 大量重复数据的数组
     */
    private static int[] repeatArray = ArrayUtils.getRepeatArray(ARRAY_LENGTH, 0, 10);

    /**
     * 最差情况数组
     */
    private static int[] badOrderArray = ArrayUtils.getBadArray(ARRAY_LENGTH);

    public static void main(String[] args) {
        //测试冒泡排序
//        testBubbleSort();
        //测试选择排序
//        testSelectionSort();
        //测试插入排序
//        testInsertionSort();
        //测试希尔排序
//        testShellSort();
        //测试归并排序
//        testMergeSort();
        //测试快速快速排序
        testQuickSort();

    }


    public static void testSelectionSort() {
//        SelectionSort.selectionSort(randomArray.clone());
        SelectionSort.selectionSort(nearlyOrderArray.clone());
//        SelectionSort.selectionSort(badOrderArray.clone());
    }

    public static void testBubbleSort() {
//        BubbleSort.bubbleSort(randomArray.clone());
        BubbleSort.bubbleSort(nearlyOrderArray.clone());
//        BubbleSort.bubbleSort(badOrderArray.clone());
        //测试优化的冒泡算法
//        BubbleSort.bubbleSortOpt(randomArray.clone());
//        BubbleSort.bubbleSortOpt(nearlyOrderArray.clone());
//        BubbleSort.bubbleSortOpt(badOrderArray.clone());

    }

    public static void testInsertionSort() {
        InsertionSort.insertionSort(randomArray.clone());
        InsertionSort.insertionSort(nearlyOrderArray.clone());
        InsertionSort.insertionSort(badOrderArray.clone());
    }

    public static void testMergeSort() {
//        MergeSort.mergeSort(randomArray.clone());
//        MergeSort.mergeSort(nearlyOrderArray.clone());
//        MergeSort.mergeSort(badOrderArray.clone());
//        MergeSort.mergeSort(repeatArray.clone());
    }

    public static void testQuickSort() {
//        QuickSort.quickSort(randomArray.clone());
//        QuickSort.quickSort(nearlyOrderArray.clone());
//        QuickSort.quickSort(badOrderArray.clone());
//        QuickSort.quickSort(repeatArray.clone());
//
//        QuickSort2Ways.quickSort(repeatArray.clone());
//        QuickSort3Ways.quickSort(repeatArray.clone());

//        QuickSort2Ways.quickSort(badOrderArray.clone());
        QuickSort3Ways.quickSort(badOrderArray.clone());
    }

    public static void testShellSort() {
        ShellSort.shellSort(randomArray.clone());
        ShellSort.shellSort(nearlyOrderArray.clone());
        ShellSort.shellSort(badOrderArray.clone());
    }
}

