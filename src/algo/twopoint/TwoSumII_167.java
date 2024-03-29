package algo.twopoint;

/**
 * @author ArnoFrost
 * @date 2020/4/8 10:38
 * @since 1.0
 * <p>
 * <p>
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1必须小于index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumII_167 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, Integer.MAX_VALUE};
        int[] result = twoSum(array, 11);
        for (int r : result) {
            System.out.println(r);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        //双指针解法
        int[] result = new int[]{-1, -1};

        if (numbers == null || numbers.length < 2) {
            return result;
        }

        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            assert (Integer.MAX_VALUE >= numbers[low] + numbers[high]);
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                result[0] = low;
                result[1] = high;
                break;
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }

        return result;


    }
}
