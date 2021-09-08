package algo.twopoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArnoFrost
 * @date 2020/4/8 13:05
 * @since 1.0
 * 给定一个字符串S和一个字符C。返回一个代表字符串S中每个字符到字符串S中的字符C的最短距离的数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 * <p>
 * 字符串S的长度范围为[1, 10000]。
 * C是一个单字符，且保证是字符串S里的字符。
 * S和C中的所有字母均为小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestToChar_821 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] result = shortestToChar(s, c);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }


    public static int[] shortestToChar(String S, char C) {
        if (S == null || S.isEmpty()) {
            return new int[]{};
        }
        List<Integer> resultList = new ArrayList<>();

        int left = 0;
        int right = -1;

        while (left < S.length()) {
            if (right + 1 < S.length() && S.charAt(right + 1) == 'e') {
                //填充
//                feed(left, right);
                for (int i = left; i < right + 1; i++) {
                    resultList.add(right - i + 1);
                }
                resultList.add(0);
                right++;
                left = right;
            } else {
                if (right + 1 < S.length()) {
                    right++;
                } else {
                    for (int i = left; i < S.length() - 1; i++) {
                        resultList.add(S.length() - left);
                    }
                    break;
                }
            }
        }
        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }

        return res;

    }
}
