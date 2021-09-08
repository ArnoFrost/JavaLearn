package algo.twopoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArnoFrost
 * @date 2020/4/8 11:11
 * @since 1.0
 * 给定一个含有n个正整数的数组和一个正整数s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组[4,3]是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试O(n log n) 时间复杂度的解法。
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

    static class Solution {
        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("abcabcbb"));
        }

        public static int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            //类似查找表 建立一个不重复的辅助空间
            int[] tempSet = new int[256];

            int left = 0;
            int right = -1;
            int length = s.length();
            int result = 0;
            while (left < length) {
                //如果没有重复
                if (right + 1 < length && tempSet[s.charAt(right + 1)] == 0) {
                    right++;
                    //放入数组
                    tempSet[s.charAt(right)]++;
                } else {
                    //命中重复
                    //移出数组
                    tempSet[s.charAt(left)]--;
                    left++;
                }
                //求最长则取最大值
                result = Math.max(result, right - left + 1);
                System.out.println("result = " + result);
            }
            return result;
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        // 计算字符串p中各元素的出现次数
        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }
        // 窗口区间为[start,end]
        int start = 0, end = -1;
        while (start < s.length()) {
            // 还有剩余元素未考察，且窗口内字符串长度小于字符串p的长度
            // 则扩大窗口右侧边界
            if (end + 1 < s.length() && end - start + 1 < p.length()) {
                end++;
            } else {
                // 右侧边界不能继续扩大或窗口内字符串长度等于字符串p的长度
                // 则缩小左侧边界
                start++;
            }
            // 当窗口内字符串长度等于字符串p的长度时 进行优化减少判断次数
            // 则判断其是不是字符串p的字母异位词子串
            if (end - start + 1 == p.length()
                    && isAnagrams(s.substring(start, end + 1), pFreq)) {
                //满足条件则放入结果集中
                resultList.add(start);
            }
        }
        return resultList;
    }

    // 判断当前子串是不是字符串p的字母异位词
    private boolean isAnagrams(String window, int[] pFreq) {
        // 计算窗口内字符串各元素的出现次数
        int[] windowFreq = new int[26];
        for (int i = 0; i < window.length(); i++) {
            windowFreq[window.charAt(i) - 'a']++;
        }
        // 比较窗口内各元素的出现次数和字符串p中各元素的出现次数是否一样
        // 如果都一样，则说明窗口内的字符串是字符串p的字母异位词子串
        // 如果不一样，则说明不是其子串
        for (int j = 0; j < windowFreq.length; j++) {
            if (windowFreq[j] != pFreq[j]) {
                return false;
            }
        }
        return true;
    }


}
