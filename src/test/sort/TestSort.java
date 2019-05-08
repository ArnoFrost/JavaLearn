package test.sort;

import junit.framework.TestCase;
import sort.BubbleSort;
import sort.InsertionSort;
import sort.MergeSort;
import sort.QuickSort;
import utils.ArrayUtils;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:35
 * @Version 1.0
 */
public class TestSort extends TestCase {
    private static int ARRAY_LENGTH = 100;
    private static int ORDER_LENGTH = 10;

    /**
     * 随机数组 注意:避免原地排序浅拷贝带来的问题
     */

//    private static int[] randomArray = new int[]{3, 4, 2, 7, 6, 9, 1, 10, 8};
    private static int[] randomArray = ArrayUtils.getRadomArray(ARRAY_LENGTH);
    private static int[] randomArray3 = randomArray.clone();
    private static int[] randomArray2 = randomArray.clone();
    private static int[] randomArray4 = randomArray.clone();

    /**
     * 近乎有序数组
     */
    private static int[] nearlyOrderArray = ArrayUtils.getNearlyOrderArray(ARRAY_LENGTH, ORDER_LENGTH);
    private static int[] nearlyOrderArray2 = nearlyOrderArray.clone();
    private static int[] nearlyOrderArray3 = nearlyOrderArray.clone();
    private static int[] nearlyOrderArray4 = nearlyOrderArray.clone();

    /**
     * 最差情况数组
     */
    private static int[] badOrderArray = ArrayUtils.getBadArray(ARRAY_LENGTH);
    private static int[] badOrderArray2 = badOrderArray.clone();
    private static int[] badOrderArray3 = badOrderArray.clone();
    private static int[] badOrderArray4 = badOrderArray.clone();


    public void testBubbleSort() {
        BubbleSort.bubbleSort(randomArray);
    }

    public void testBubbleSort2() {
        BubbleSort.bubbleSort(nearlyOrderArray);
    }

    public void testBubbleSort3() {
        BubbleSort.bubbleSort(badOrderArray);
    }

    public void testInserstionSort() {
        InsertionSort.insertionSort(randomArray2);

    }

    public void testInserstionSort2() {
        InsertionSort.insertionSort(nearlyOrderArray2);
    }

    public void testInserstionSort3() {
        InsertionSort.insertionSort(badOrderArray2);
    }

    public void testMergeSort() {
        MergeSort.mergeSort(randomArray3);
    }

    public void testMergeSort2() {
        MergeSort.mergeSort(nearlyOrderArray3);
    }

    public void testMergeSort3() {
        MergeSort.mergeSort(badOrderArray3);
    }

    public void testQuickSort() {
        QuickSort.quickSort(randomArray4);
    }

    public void testQuickSort2() {
        QuickSort.quickSort(nearlyOrderArray4);
    }

    public void testQuickSort3() {
        QuickSort.quickSort(badOrderArray4);
    }
}
