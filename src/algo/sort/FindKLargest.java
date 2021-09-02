package algo.sort;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/7 17:25
 * @Version 1.0
 */
public class FindKLargest {

    public int findK(int[] arry, int k) {
        myquickSort(arry, 0, arry.length, k);
        return arry[k - 1];
    }

    private static void myquickSort(int[] arry, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int p = arry[left];

        int lt = left;
        int gt = right + 1;

        int i = left + 1;

        while (i < gt) {
            if (arry[i] > p) {
                int temp = arry[i];
                arry[i] = arry[lt + 1];
                arry[lt + 1] = temp;
                lt++;
                i++;
            } else if (arry[i] < p) {
                int temp = arry[i];
                arry[i] = arry[gt - 1];
                arry[gt - 1] = temp;
                gt--;
            } else {
                i++;
            }

            int temp = arry[lt];
            arry[lt] = arry[left];
            arry[left] = temp;
            if (lt > k - 1) {
                myquickSort(arry, left, lt - 1, k);
            } else {
                myquickSort(arry, gt, right, k);
            }
        }
    }


    public int findKthLargest(int[] nums, int k) {
        //重复的要算
        //那么就考虑三路快速排序(重复值多的情况下适合三路快排)
        //最好情况下时间复杂度O(nlogn)
        //最好情况下空间复杂度O(logn)，每轮递归要保存一些数据，一共logn轮
        quickSort(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }

    public void quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        //选择标定点，一般是随机选取
        int pivot = nums[l];
        //[0...lt]
        int lt = l;
        //[gt...r]
        int gt = r + 1;
        //[lt + 1... i - 1]
        int i = l + 1;
        while (i < gt) {
            if (nums[i] > pivot) {
                int temp = nums[i];
                nums[i] = nums[lt + 1];
                nums[lt + 1] = temp;
                ++lt;
                ++i;
            } else if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[gt - 1];
                nums[gt - 1] = temp;
                --gt;
            } else {
                ++i;
            }
        }
        int temp = nums[lt];
        nums[lt] = nums[l];
        nums[l] = temp;
        if (lt > k - 1) {//剪枝操作
            quickSort(nums, l, lt - 1, k);
        } else {
            quickSort(nums, gt, r, k);
        }
    }
}
