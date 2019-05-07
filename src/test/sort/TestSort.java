package test.sort;

import junit.framework.TestCase;
import sort.BubbleSort;
import sort.InsertionSort;
import utils.ArrayUtils;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:35
 * @Version 1.0
 */
public class TestSort extends TestCase {
    private static int[] randomArray = ArrayUtils.getRadomArray(10000);
    /**
     * 避免原地排序浅拷贝带来的问题
     */
    private static int[] randomArray2 = randomArray.clone();
    private static int[] nearlyOrderArray = ArrayUtils.getNearlyOrderArray(10000, 100);

    public void testBubbleSort() {
        BubbleSort.bubbleSort(randomArray);
    }

    public void testInserstionSort() {
        InsertionSort.insertionSort(randomArray2);

    }

    public void testInserstionSort2() {
        InsertionSort.insertionSort(nearlyOrderArray);
    }
}
