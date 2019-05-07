package array;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-07 15:41
 * @Version 1.0
 * Code ==> 215.
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class FindKthLargest {
    //利用快排的思路 最小堆待更新
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return Integer.MAX_VALUE;
        }
        if (nums.length < k) {
            return Integer.MAX_VALUE;
        }
        return quickSortInternally(nums, 0, nums.length - 1, k);
    }

    public static int quickSortInternally(int[] arr, int leftIndex, int rightIndex, int k) {
        if (leftIndex > rightIndex) {
            return Integer.MAX_VALUE;
        }
        //快排标记
        int i = leftIndex;
        int j = rightIndex;
        int temp = arr[i];

        while (i < j) {
            //把小于temp的数都放到右边
            while (i < j && arr[j] < temp) {
                j--;
            }
            //如果右边出现大于temp的数，就跟左边交换
            if (i < j) {
                arr[i++] = arr[j];
            }
            //把大于等于temp的数都放到左边
            while (i < j && arr[i] >= temp) {
                i++;
            }
            //如果左边出现小于temp的数，就跟右边交换
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = temp;
        //如果temp的位置为k-1，那么他就是第k个最大的数
        if (i == k - 1) {
            return temp;
        }
        //如果temp的位置大于k-1，说明第k个最大的数在左边
        else if (i > k - 1) {
            return quickSortInternally(arr, leftIndex, i - 1, k);
        } else {//如果temp的位置小于k-1，说明第k个最大的数在右边
            return quickSortInternally(arr, i + 1, rightIndex, k);
        }
    }
}
