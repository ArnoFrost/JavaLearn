package algo.twopoint;

/**
 * @author ArnoFrost
 * @date 2020/4/7 10:01
 * @since 1.0
 */
public class RemoveDuplicatedFromSortedArray_26 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(a);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(a[j] + ",");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //双指针
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
