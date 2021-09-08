package algo.sort;

import datastruct.utils.ArrayUtils;

/**
 * @author ArnoFrost
 * @date 2020/4/6 14:21
 * @since 1.0
 */
public class FindK {
    /**
     * 随机数组 注意:避免原地排序浅拷贝带来的问题
     */

    private static final int ARRAY_LENGTH = 100000;

    private static int[] array = ArrayUtils.getBadArray(ARRAY_LENGTH);

    public static void main(String[] args) {
        int k = 500;
//        datastruct.array = new int[]{9, 3, 6, 7, 4, 5, 1, 2, 8, 9, 10};
        findK(k, array, 0, array.length - 1);
    }

    private static void findK(int k, int[] array, int left, int right) {
        int partitionIndex = partition(array, left, right);
        if (partitionIndex == k) {
            System.out.println("k = " + array[partitionIndex - 1]);
        } else if (partitionIndex > k - 1) {
            findK(k, array, left, partitionIndex - 1);
        } else {
            findK(k, array, left + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int v = array[left];
        int partitionIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < v) {
                ArrayUtils.swapArray(array, ++partitionIndex, i);
            }
        }
        ArrayUtils.swapArray(array, partitionIndex, left);

        return partitionIndex;
    }


}
