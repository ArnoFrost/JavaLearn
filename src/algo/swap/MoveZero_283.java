package algo.swap;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/6 19:03
 * @Version 1.0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZero_283 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 0, 3, 2, 0};
        moveZero(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    public static int[] moveZero(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }
        //标记不是0的索引
        int k = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    //交换完成后 k索引加一
                    swapArray(nums, i, k++);
                }
            }
        }

        return nums;
    }


    public static int[] swapArray(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        return a;
    }
}
