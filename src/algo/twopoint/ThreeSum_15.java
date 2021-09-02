package algo.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/9 20:00
 * @Version 1.0
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] arry = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arry));

    }

    /**
     * 解法一 用滑动窗口 演进成 twosum 版本
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            //去重操作
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            //left
            int left = i + 1;
            //right
            int right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);

                    result.add(tempList);
                    left++;
                    right--;
                    //去重操作
                    while (left < length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

}
