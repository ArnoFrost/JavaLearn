package leetcode.twopoint;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/7 11:38
 * @Version 1.0
 */
public class RemoveDuplicatedFromSortedArrayII_80 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicatesII(a);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(a[j] + ",");
        }
    }

    public static int removeDuplicatesII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //双指针
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
