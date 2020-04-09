package leetcode.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/9 20:51
 * @Version 1.0
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum_18 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(array, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        /*定义一个返回值*/
        List<List<Integer>> result = new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if (nums == null || nums.length < 4) {
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length = nums.length;
        /*定义4个指针a，b，c，d  a从0开始遍历，b从a+1开始遍历，留下c和d，c指向b+1，d指向数组最大值*/
        for (int a = 0; a < length - 3; a++) {
            /*当a的值与前面的值相等时去重忽略*/
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min = nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3];
            if (min > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[a] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            /*第二层循环b，初始值指向a+1*/
            for (int b = a + 1; b < length - 2; b++) {
                /*当b的值与前面的值相等时忽略去重*/
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                /*定义指针c指向b+1*/
                int c = b + 1;
                /*定义指针d指向数组末尾*/
                int d = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min2 = nums[a] + nums[b] + nums[c] + nums[c + 1];
                if (min2 > target) {
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[a] + nums[b] + nums[d] + nums[d - 1];
                if (max < target) {
                    continue;
                }
                //核心过程 维护定义 双指针解法
                /*开始c指针和d指针的表演，计算当前和，如果等于目标值，c++并去重，d--并去重，当当前和大于目标值时d--，当当前和小于目标值时c++*/
                while (c < d) {
                    int curr = nums[a] + nums[b] + nums[c] + nums[d];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        //去重操作
                        while (c < d && nums[c] == nums[c - 1]) {
                            c++;
                        }
                        d--;
                        while (c < d && b < d && nums[d] == nums[d + 1]) {
                            d--;
                        }
                        //移动指针
                    } else if (curr > target) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }
        return result;
    }
}
