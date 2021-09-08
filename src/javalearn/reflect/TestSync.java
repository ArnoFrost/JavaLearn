/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.reflect;

/**
 * @author ArnoFrost
 * @date 2020/8/17 16:34
 * @since 1.0
 */
public class TestSync {
    public static void main(String[] args) {
        TestSync sync = new TestSync();
        sync.test();

    }

    private void test() {
        final TestSynchronized test1 = new TestSynchronized();
        final TestSynchronized test2 = new TestSynchronized();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
//                test1.method01("a");
                test1.method02("a");
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
//                test2.method01("b");
                test2.method02("a");
            }
        });
        t1.start();
        t2.start();
    }

    private static class TestSynchronized {
        private int num1;

        public synchronized void method01(String arg) {
            try {
                if ("a".equals(arg)) {
                    num1 = 100;
                    System.out.println("tag a set number over");
                    Thread.sleep(1000);
                } else {
                    num1 = 200;
                    System.out.println("tag b set number over");
                }
                System.out.println("tag = " + arg + ";num =" + num1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static int num2;

        public static synchronized void method02(String arg) {
            try {
                if ("a".equals(arg)) {
                    num2 = 100;
                    System.out.println("tag a set number over");
                    Thread.sleep(1000);
                } else {
                    num2 = 200;
                    System.out.println("tag b set number over");
                }
                System.out.println("tag = " + arg + ";num =" + num2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
