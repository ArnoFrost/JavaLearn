package algo.swap;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/9 21:18
 * @Version 1.0
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 
 * <p>
 * 示例 1：
 * <p>
 * 输入：['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 * 示例 2：
 * <p>
 * 输入：['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseString_344 {
    public static void main(String[] args) {
        char[] test = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(test);
        System.out.println(test);

        String testStr = "olleh";
        char[] test2 = testStr.toCharArray();
        reverseString(test2);
        System.out.println(test2);

    }

    public static void reverseString(char[] s) {
        //小于2个不用交换
        if (s == null || s.length < 2) {
            return;
        }
        //中间元素不用交换
        int mid = s.length / 2;
        int k = s.length - 1;
        for (int i = 0; i < mid; i++) {
            //原地交换
            char temp = s[i];
            s[i] = s[k - i];
            s[k - i] = temp;
        }


    }
}
