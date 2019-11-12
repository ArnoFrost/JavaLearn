package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: ArnoFrost
 * @Date: 2019-06-06 23:00
 * @Version 1.0
 */
public class TestData {

    public static void main(String[] args) {
//        String content = "1ASDFD&2ASDFG&3ASDFG&4ASDFG";
        String content =
                "1ASD FD&2ASD FG&3AS DFG&4AS DFG" + " &\n";
//        String content = " &\n" +
//                " 100Ae3&2002f4&33CD56&44456F";

        System.out.println("is matched = " + isMatchHoneyWellTy(content));
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;

    }

    public static boolean isMatchHoneyWellTy(String content) {

        content = replaceBlank(content);

        System.out.println("content == " + content);
        if (content != null) {
//            Pattern p = Pattern.compile("^1[a-zA-Z0-9_]{5}&2[a-zA-Z0-9_]{5}&3[a-zA-Z0-9_]{5}&4[a-zA-Z0-9_]{5}$");
            Pattern p = Pattern.compile("^1[0-9|A-Z|a-z]{5}&2[0-9|A-Z|a-z]{5}&3[0-9|A-Z|a-z]{5}&4[0-9|A-Z|a-z]{5}");


            Matcher m = p.matcher(content);

            return m.find();
        } else {
            return false;
        }
    }
}
