package leetcode.find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    static class Pair {
        int x;
        int y;

        public Pair() {
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }
        List<Pair> pairList = new ArrayList<>();
        //先放入数组
        for (int i = 0; i < points.length; i++) {
            pairList.add(new Pair(i, points[i][0]));
        }
//        System.out.println(pairList.size());
        //key i到其他点距离 value 出现次数
        //当点大于2的时候 有A(n,2)种可能 n*n-1
        Map<Integer, Integer> hashMap = new HashMap<>();
        int size = pairList.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= i) {
                    int distance = distance(pairList.get(i).x, pairList.get(i).y, pairList.get(j).x, pairList.get(j).y);
                    System.out.println("distance  = " + distance);
                    hashMap.put(distance, hashMap.getOrDefault(distance, 0) + 1);
                }
            }
        }

        int res = 0;
        //遍历查找表的集合
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            //刨除0 的点
            if (entry.getKey() > 0 && entry.getValue() >= 2) {
                res += entry.getValue() * (entry.getValue() - 1);
            }
        }

        System.out.println("values = " + hashMap.values());

        return res;
    }

    private static int distance(int ax, int ay, int bx, int by) {
        return (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
    }
}
