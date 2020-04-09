package leetcode.find;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/9 18:26
 * @Version 1.0
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int[] result = twoSum(array, 9);
        if (result != null) {
            for (int i : result) {
                System.out.println(i);
            }
        } else {
            System.err.println("null !!");
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        //创建hashMap的查找表 key 值, value 索引
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            //减少遍历 提前结束
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;


    }
}
