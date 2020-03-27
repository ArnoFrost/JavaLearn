package test.sort;

import junit.framework.TestCase;
import sort.*;
import utils.ArrayUtils;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:35
 * @Version 1.0
 */
public class SortTest extends TestCase {
    /**
     * 数组长度
     */
    private static int ARRAY_LENGTH = 10000;
    /**
     * 有序数字个数
     */
    private static int ORDER_LENGTH = 100;

    /**
     * 随机数组 注意:避免原地排序浅拷贝带来的问题
     */

    private static int[] randomArray = ArrayUtils.getRadomArray(ARRAY_LENGTH);

    /**
     * 近乎有序数组
     */
    private static int[] nearlyOrderArray = ArrayUtils.getNearlyOrderArray(ARRAY_LENGTH, ORDER_LENGTH);

    /**
     * 最差情况数组
     */
    private static int[] badOrderArray = ArrayUtils.getBadArray(ARRAY_LENGTH);

    public static void main(String[] args) {
//        testBubbleSort();
        //测试选择排序
        testSelectionSort();
        //测试插入排序
        testInsertionSort();

//
//
//        testMergeSort();
//
//        testQuickSort();

    }


    public static void testSelectionSort() {
        SelectionSort.selectionSort(randomArray.clone());
        SelectionSort.selectionSort(nearlyOrderArray.clone());
        SelectionSort.selectionSort(badOrderArray.clone());
    }

    public static void testBubbleSort() {
        BubbleSort.bubbleSort(randomArray.clone());
        BubbleSort.bubbleSort(nearlyOrderArray.clone());
        BubbleSort.bubbleSort(badOrderArray.clone());
    }

    public static void testInsertionSort() {
        InsertionSort.insertionSort(randomArray.clone());
        InsertionSort.insertionSort(nearlyOrderArray.clone());
        InsertionSort.insertionSort(badOrderArray.clone());
    }

    public static void testMergeSort() {
        MergeSort.mergeSort(randomArray.clone());
        MergeSort.mergeSort(nearlyOrderArray.clone());
        MergeSort.mergeSort(badOrderArray.clone());
    }

    public static void testQuickSort() {
        QuickSort.quickSort(randomArray.clone());
        QuickSort.quickSort(nearlyOrderArray.clone());
        QuickSort.quickSort(badOrderArray.clone());
    }
}

