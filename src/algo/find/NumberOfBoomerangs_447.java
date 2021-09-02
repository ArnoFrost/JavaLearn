package algo.find;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/10 14:09
 * @Version 1.0
 */
public class NumberOfBoomerangs_447 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }
        int res = 0;
        //key i到其他点距离 distance value 出现次数
        //当点大于2的时候 有A(n,2)种可能 n*n-1
        int length = points.length;
        for (int i = 0; i < length; i++) {
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    int distance = getDistance(points[i], points[j]);
                    System.out.println("distance = " + distance);
                    hashMap.put(distance, hashMap.getOrDefault(distance, 0) + 1);
                }
            }
            // 排列组合 计数
            for (int count : hashMap.values()) {
                res += count * (count - 1);
            }
        }
        return res;
    }

    // 计算距离（平方和）
    private static int getDistance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
