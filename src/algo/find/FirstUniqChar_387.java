package algo.find;

import java.util.HashMap;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/17 10:52
 * @Version 1.0
 */
public class FirstUniqChar_387 {
    public static void main(String[] args) {
//        String s = "algo.leetcode";
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build datastruct.hash datastruct.map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
