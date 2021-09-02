package algo.find;

import java.util.*;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/10 11:54
 * @Version 1.0
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "boo", "bob"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            if (str != null) {
                char[] tempCharArray = str.toCharArray();
                Arrays.sort(tempCharArray);
                String key = String.valueOf(tempCharArray);
                if (hashMap.containsKey(key)) {
                    List<String> strList = hashMap.get(key);
                    strList.add(str);
                    hashMap.put(key, strList);
                } else {
                    List<String> strList = new ArrayList<>();
                    strList.add(str);
                    hashMap.put(key, strList);
                }
            }
        }

        //遍历查找表的集合
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    /**
     * 简化写法
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList());
            }
            hashMap.get(key).add(s);
        }
        return new ArrayList(hashMap.values());

    }
}
