package leetcode.find;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/10 16:10
 * @Version 1.0
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyDuplicated_219 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(array, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        //key保存每个相同数 value 差值最小数i
        Map<Integer, Integer> hashMap = new HashMap<>();

        //标识含有相同元素的值的两个索引
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == nums[right - 1]) {

            } else {
                hashMap.put(1, hashMap.getOrDefault(1, 0) + 1);
            }
        }
        return false;
    }

}
