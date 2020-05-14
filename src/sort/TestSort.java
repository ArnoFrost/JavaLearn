package sort;

import utils.ArrayUtils;

import java.util.Arrays;

public class TestSort {
    private static int[] randomArray = ArrayUtils.getRadomArray(100000);

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(randomArray));
//        int[] bubble = bub(randomArray);
//        mergeSort(randomArray.clone());
        quickSortNew(randomArray.clone());

//        compute(s);
//        System.out.println("共有" + sum + "种走法");
//        System.out.println(Arrays.toString(randomArray));

    }

//    public int compute(int stair) {
//        if (stair <= 0) {
//            return 0;
//        }
//        if (stair == 1) {
//            return 1;
//        }
//        if (stair == 2) {
//            return 2;
//        }
//        return compute(stair - 1) + compute(stair - 2);
//    }


    static final int s = 10;  //自定义的台阶数
    static int len = 0, sum = 0;

    //最多也只有走100步就到了
    static int step[] = new int[s];

    //3
    static void compute(final int stair) {
        if (stair < 0)
            return;

        //表示已经走完了
        if (stair == 0) {
            printSum();
            sum++;
            return;
        }

        //每次到下一步选择时都可以走1-3步
        for (int i = 1; i <= 3; i++) {
            step[len] = i;
            len++;

            //进行下一步的迭代，迭代完之后将每后加上的一步去掉，换成其它的步数(如从1换成2)
            compute(stair - i);
            len--;
        }
    }

    static void printSum() {
        System.out.print("走法:");
        for (int i = 0; i < len; i++)
            System.out.print(step[i] + " ");
        System.out.println();
    }


    private static void mergeSort(int[] array) {
        mergeSortInternally(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSortInternally(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSortInternally(array, left, middle);
        mergeSortInternally(array, middle + 1, right);

        if (array[middle] > array[middle + 1]) {
            doMerge(array, left, middle, right);
        }
    }

    private static void doMerge(int[] array, int left, int middle, int right) {
        int l = left;
        int r = middle + 1;
        int[] tmp = new int[right - left + 1];


        int i = 0;
        while (l <= middle && r <= right) {
            if (array[l] > array[r]) {
                tmp[i++] = array[r++];
            } else {
                tmp[i++] = array[l++];
            }
        }
        int start, end;
        if (l <= middle) {
            start = l;
            end = middle;
        } else {
            start = r;
            end = right;
        }
        while (start <= end) {
            tmp[i++] = array[start++];
        }

        System.arraycopy(tmp, 0, array, left, tmp.length);


    }

    private static void quickSortNew(int[] array) {
        quickSortNewInternally(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSortNewInternally(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pIndex = partition(array, left, right);

        quickSortNewInternally(array, left, pIndex - 1);
        quickSortNewInternally(array, pIndex + 1, right);


    }

    private static int partition(int[] array, int left, int right) {
        int v = array[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (array[i] < v) {
                ArrayUtils.swapArray(array, ++j, i);
            }
        }

        ArrayUtils.swapArray(array, left, j);
        return j;
    }


}
