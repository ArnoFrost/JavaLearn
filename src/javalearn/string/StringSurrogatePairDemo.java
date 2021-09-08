/*
 * Copyright (c) 2021-2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.string;

/**
 * @author ArnoFrost
 * @since 2021/9/7 17:36
 */
public class StringSurrogatePairDemo {
    public static void main(String[] args) {
        String a = "你";
        String b = "\uD835\uDFD8";
        String c = "a";
        String d = "\uD835";

        printText(a);
        printText(b);
        printText(c);
        printText(d);
    }

    private static void printText(String text) {
        int length = text.length();
        boolean isSingle = text.matches(".");
        System.out.println("文字是: " + text + ",长度是: " + length + ",是否是单字: " + isSingle);
    }
}
