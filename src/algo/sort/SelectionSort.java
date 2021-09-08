package algo.sort;

import datastruct.utils.TestUtils;

import java.util.Arrays;

/**
 * @author ArnoFrost
 * @date 2020-03-27 19:01
 * @since 1.0
 */
public class SelectionSort {

    public static void selectionSort(int[] a) {
        TestUtils.printStartTime();
        System.out.println(SelectionSort.class.getSimpleName());
        if (a == null || a.length == 1) {
            System.out.println("datastruct.array is null or length is only 1");
            return;
        }
        System.out.println("before sort a = [" + Arrays.toString(a) + "]");
        int length = a.length;
        int minIndex, temp;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }

        System.out.println("after sort a = [" + Arrays.toString(a) + "]");
        TestUtils.printCostTime();
    }

    public static void selectTion(int[] a) {

    }
}
