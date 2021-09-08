/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.jvm;

/**
 * @author ArnoFrost
 * @date 2020/5/21 15:54
 * @since 1.0
 */
public class Jvm {
    public static void main(String[] args) {
        testString();
    }

    private static void testString() {
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println("s1 = " + s1);
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja")
                .append("va").toString();
//        String s2 = new StringBuilder("go")
//                .append("od").toString();
        System.out.println("s2 = " + s2 + ",s2.intern = " + s2.intern());
        System.out.println(s2.intern() == s2);
//        System.out.println(s2.intern() == s1);

        String s3 = new StringBuilder("he")
                .append("llo").toString();
        System.out.println(s3.intern() == s3);

//        String s0= "kvill";
//        String s1=new String("kvill");
//        String s2=new String("kvill");
//        System.out.println( s0==s1 );
//        System.out.println("**********" );
//        s1.intern();
//        s2=s2.intern(); //把常量池中“kvill”的引用赋给s2
//        System.out.println( s0==s1);
//        System.out.println( s0==s1.intern() );
//        System.out.println( s0==s2 );
    }
}
