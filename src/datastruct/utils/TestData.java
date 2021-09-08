package datastruct.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ArnoFrost
 * @date 2019-06-06 23:00
 * @since 1.0
 */
public class TestData {

    private static final Pattern P = Pattern.compile("\\s|\t|\r|\n");
    private static final Pattern P2 = Pattern.compile("^1[0-9|A-Z|a-z]{5}&2[0-9|A-Z|a-z]{5}&3[0-9|A-Z|a-z]{5}&4[0-9|A-Z|a-z]{5}");


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
            Matcher m = P.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;

    }

    public static boolean isMatchHoneyWellTy(String content) {

        content = replaceBlank(content);

        System.out.println("content == " + content);
        if (content != null) {
            Matcher m = P2.matcher(content);
            return m.find();
        } else {
            return false;
        }
    }
}
