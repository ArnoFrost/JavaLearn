package algo.find;

import java.util.HashMap;

/**
 * @author ArnoFrost
 * @date 2020/4/9 18:26
 * @since 1.0
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int[] result = twoSum(array, 18);
        if (result != null) {
            for (int i : result) {
                System.out.println(i);
            }
        } else {
            System.err.println("null !!");
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (hashMap.containsKey(need)) {
                return new int[]{hashMap.get(need), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
