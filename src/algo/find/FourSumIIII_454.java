package algo.find;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/10 10:57
 * @Version 1.0
 * <p>
 * 给定四个包含整数的数组列表A , B , C , D ,计算有多少个元组 (i, j, k, l)，使得A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSumIIII_454 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};


        System.out.println(fourSumCount(A, B, C, D));
    }

    /**
     * 将CD 所有可能值放入hash查找表,转化为twosum
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //建立查找表 key 是 c+d的值 value 是 相同的sum 出现的次数
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                //满足条件记录+1
                hashMap.put(c + d, hashMap.getOrDefault(c + d, 0) + 1);
            }
        }

        int res = 0;
        //twosum解法
        for (int a : A) {
            for (int b : B) {
                int target = a + b;
                if (hashMap.containsKey(-target)) {
                    //满足条件记录数值
                    res += hashMap.getOrDefault(-target, 0);
                }
            }
        }

        return res;
    }

    public static int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        assert (A != null && B != null && C != null && D != null
                & A.length == B.length && B.length == C.length && C.length == D.length);
        Map<Integer, Integer> hashMap = new HashMap<>(A.length);
        int res = 0;
        for (int a : A) {
            for (int b : B) {
                int key = a + b;
                if (hashMap.containsKey(key)) {
                    hashMap.put(key, hashMap.get(key) + 1);
                } else {
                    hashMap.put(key, 1);
                }
            }
        }

        for (int c : C) {
            for (int d : D) {
                int key = c + d;
                if (hashMap.containsKey(0 - key)) {
                    res += hashMap.get(0 - key);
                }
            }
        }
        return res;
    }
}
