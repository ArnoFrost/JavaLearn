/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArnoFrost
 * @date 2021/4/30 17:55
 * @since 1.0
 */
public class TestJava {
    private List<String> mList = new ArrayList<>();
    private List<String> mList2 = new ArrayList<>();

    public TestJava() {
        mList2.add("mList2");
    }

    private void addAndClean(List<String> list) {
        list.add("String");
//        list = null;
//        list.clear();
        list = mList2;
    }

    private void test() {
        addAndClean(mList);
        System.out.println(mList);
    }

    private void test2() {
        mList.add("String");
//        mList = null;
//        mList.clear();
        mList = mList2;
        System.out.println(mList);
    }

    public static void main(String[] args) {
        TestJava testJava = new TestJava();
        testJava.test();
        testJava.test2();
    }
}
