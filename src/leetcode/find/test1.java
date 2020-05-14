package leetcode.find;

public class test1 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
//        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {
        int length = 0;
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - 64;
            length += num * Math.pow(26, j);
            j++;

        }

        return length;
    }
}
