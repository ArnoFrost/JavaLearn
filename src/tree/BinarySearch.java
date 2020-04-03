package tree;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/2 19:03
 * @Version 1.0
 */
public class BinarySearch {
    //数据已经排好序
    public static int binarySearch(int[] arr, int searchData) {
        if (arr == null) {
            return -1;
        }
        int lIndex = 0;
        int rIndex = arr.length - 1;

        while (lIndex <= rIndex) {
            //防止int 值溢出 Integer.MAX_VALUE
            int middle = lIndex + (rIndex - lIndex) / 2;

            if (arr[middle] == searchData) {
                return middle;
            }
            //[middle + 1, rIndex]
            if (searchData > arr[middle]) {
                lIndex = middle + 1;
            } else {//[l, middle - 1]
                rIndex = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int size = 100000;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        int index = binarySearch(array, 5678);
        System.out.println("index = " + index);
    }
}
