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
 * @date 2020/5/21 17:44
 * @since 1.0
 */
public class LoadClass {
    public static class SuperClass {
        static {
            System.out.println("SuperClass static init");
        }

        //不添加final 则执行初始化
//        public static String ABC = "abc";
        //final 则不用进行初始化
        public final static String ABC = "abc";
    }

    public static class SubClass extends SuperClass {
        static {
            System.out.println("SubClass static init");
        }
    }

    public static void main(String[] args) {
        //调用静态变量则只有直接声明的字段类才会初始化
        System.out.println(SubClass.ABC);
    }
}
