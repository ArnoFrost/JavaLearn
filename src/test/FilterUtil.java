package test;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/**
 * @Author: ArnoFrost
 * @Date: 2020/6/10 20:28
 * @Version 1.0
 */
public class FilterUtil {
    //    private static final String KOREAN_PATTERN = "/x3130-/x318F";
//    private static final String KOREAN_PATTERN2 = "/xAC00-/xD7A3";
//    private static final Pattern KOREAN = Pattern.compile("^[\\u1100-\\u11ff\\uac00-\\ud7af\\u3130–\\u318F\\u3200–\\u32FF\\uA960–\\uA97F\\uD7B0–\\uD7FF\\uFF00–\\uFFEF\\w\\s]+$");
    private static final Pattern KOREAN = Pattern.compile("^[\\uac00-\\ud7af\\w\\s]+$");
    private static final Pattern NORMAL = Pattern.compile("(?i)[a-z0-9\\u4e00-\\u9fa5]");
    private static final String CANT_SEE = "[\\u001E-\\uffff]+";

    public static boolean hasKorean(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        return KOREAN.matcher(string).find();
    }

    /**
     * 判断字符串是否为中文
     *
     * @param input
     * @return
     */
    public static boolean isChinese(String input) {
        return input.matches("^[\u4e00-\u9fa5]+$");
    }

    /**
     * 判断字符串是否为日文
     *
     * @param input
     * @return
     */
    public static boolean isJapanese(String input) {
        try {
            return input.getBytes("shift-jis").length >= (2 * input.length());
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }


    public static String replaceCantSee(String content) {
        if (content == null || content.isEmpty()) {
            return "";
        }
        return content.replaceAll(CANT_SEE, "");
    }


    /**
     * 过滤火星文
     *
     * @param in
     * @return
     */
    public static String validaString(String in) {
        StringBuffer out = new StringBuffer(); // Used to hold the output.
        char current; // Used to reference the current character.

        if (in == null || ("".equals(in)))
            return ""; // vacancy test.
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught
            // here; it should not happen.
            if ((current == 0x9) || (current == 0xA)
                    || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))
                    || ((current >= 0x10000) && (current <= 0x10FFFF)))
                out.append(current);
        }
        return out.toString();
    }

    /**
     * 去掉字符串中的标点符号、空格和数字
     *
     * @param input
     * @return
     */
    public static String removePunctuation(String input) {
        return input.replaceAll(" +", "").replaceAll("[\\pP\\p{Punct}]", "").replaceAll("\\d+", "");
    }

    private static final String KOREA = "123 Love 죽도록 사랑해";
    private static final String CHINA = "雪中悍刀行之剑气满北凉 853";
    private static final String JAPANESE = "123僕らの手には何もないけど";
    private static final String RUSSIAN = "Одинокий молодой12(,&";
    private static final String ENGLISH = "hello world";
    private static final String MARS = "▂呮遈突嘫洧些";
    private static final String MARS2 = "▂呮遈突嘫洧些";

    public static void main(String[] args) {
//        String content = RUSSIAN;
//        String temp = removePunctuation(content);
//        if (hasKorean(content)) {
//            content = "韩语歌";
//        } else if (isJapanese(temp)) {
//            System.out.println("日语歌");
//        } else {
//            content = replaceCantSee(content);
//            content = validaString(content);
//        }

        System.out.println(getSongName(CHINA));
//        System.out.println(getSongName(RUSSIAN));
        System.out.println(getSongName(KOREA));
//        System.out.println(getSongName(MARS));
    }

    public static String getSongName(String content) {
        if (hasKorean(content)) {
            return "我不认识这个歌名";
        } else {
            return validaString(content);
        }
    }
}
