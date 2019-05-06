package test.sort;

import junit.framework.TestCase;
import sort.InsertionSort;
import utils.ArrayUtils;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-06 20:35
 * @Version 1.0
 */
public class TestSort extends TestCase {

    public void testInserstionSort() {
        InsertionSort.insertionSort(ArrayUtils.getSimpleArray(100000));

    }

    public void testInserstionSort2() {
        InsertionSort.insertionSort(ArrayUtils.getNearlyOrderArray(100000, 10));
    }
}
