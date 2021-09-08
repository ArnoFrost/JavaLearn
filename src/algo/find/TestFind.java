package algo.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ArnoFrost
 * @date 2020/4/11 21:09
 * @since 1.0
 */
public class TestFind {
    public static void main(String[] args) {
        TwoSum sum = new TwoSum();

        sum.add(3);
        sum.add(2);
        sum.add(1);

        System.out.println(sum.find(2));
//        System.out.println(sum.find(3));
//        System.out.println(sum.find(4));
//        System.out.println(sum.find(5));
//        System.out.println(sum.find(6));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList<>();
        //排序优化提前停止
        Arrays.sort(nums);

        // Map<Integer,Integer> datastruct.map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {//左指针遍历到位置提前停止优化,因为有序
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

            //双指针遍历 转化成twosum方法
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    //满足条件加入
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    //完成一次统计
                    result.add(tempList);
                    //继续维护索引 (此处并没去重)
                    left++;
                    right--;
                    //去重操作,保证可以添加
                    //当指针移动到相同元素,则跳过,注意索引越界与边界问题
                    while (left < length && nums[left - 1] == nums[left]) {
                        //相同的左指针元素 继续移动
                        left++;
                    }

                    while (right > left && nums[right + 1] == nums[right]) {
                        //相同的右指针元素 继续移动
                        right--;
                    }
                } else if (sum > target) {
                    //超过查找值 右指针移动
                    right--;
                } else {
                    //小于查找值 左指针移动
                    left++;
                }
            }
        }
        return result;
    }
}
