package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ArnoFrost
 * @Date: 2021/4/30 17:55
 * @Version 1.0
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
