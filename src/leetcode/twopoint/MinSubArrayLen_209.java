package leetcode.twopoint;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/8 11:11
 * @Version 1.0
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSubArrayLen_209 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 2, 4, 3};
        int sum = 7;
        System.out.println(minSubArrayLen(sum, array));


    }

    public static int minSubArrayLen(int s, int[] nums) {
        int len = 0;
        if (nums == null) {
            return len;
        }
        //滑动窗口解法
        int left = 0; //nums[l..r] 闭区间
        int right = -1;

        int length = nums.length;
        int sum = 0;
        len = length + 1;
        while (left < length) {
            if (right + 1 < length && sum < s) {
                right++;
                sum += nums[right];
            } else {
                sum -= nums[left];
                left++;
            }

            if (sum >= s) {
                len = Math.min(len, right - left + 1);
            }

            System.out.println("len = " + len + ",sum = " + sum + ",left = " + left + ",right = " + right);
        }

        if (len == length + 1) {
            return 0;
        }
        return len;
    }
}
