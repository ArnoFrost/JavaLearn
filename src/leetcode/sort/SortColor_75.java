package leetcode.sort;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/7 11:58
 * @Version 1.0
 */
public class SortColor_75 {
    public static void main(String[] args) {

    }

    public static void sortColors(int[] nums) {
        //有限数 使用计数排序
        if (nums == null || nums.length == 0) {
            return;
        }
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            switch (num) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }

        for (int i = 0; i < count1; i++) {
            nums[i + count0] = 1;
        }
        for (int i = 0; i < count2; i++) {
            nums[i + count0 + count1] = 2;
        }


    }
}
