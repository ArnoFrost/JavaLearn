package leetcode.delete;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/6 19:19
 * @Version 1.0
 */
public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 1, 6, 5, 3};
        int length = removeElement(nums, 2);
//        int[] nums = new int[]{3, 2, 2, 3,3};
//        int length = removeElement(nums, 3);
        System.out.println("length = " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        //双指针移动记录
        //遍历
        int i = 0;
        //标记后面,向前放入删除元素
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }
        return n;
    }

}
