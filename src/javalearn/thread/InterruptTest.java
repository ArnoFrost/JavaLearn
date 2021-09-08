/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.thread;

/**
 * @author ArnoFrost
 * @date 2020/8/13 12:45
 * @since 1.0
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
//                    for (int i = 0; i < 10000; i++) {
////                    if (isInterrupted()) {
////                        break;
////                    }
//                        System.out.println(i);
//                    }
                    Thread.sleep(2000);

                } catch (Exception e) {
                    System.out.println("1 is = " + interrupted());
                    System.out.println("2 is = " + interrupted());

//                    e.printStackTrace();
                }
            }
        };
        thread.start();
//        java.thread.isInterrupted();
        thread.interrupt();
        System.out.println("3 is = " + Thread.interrupted());
        System.out.println("4 is = " + Thread.interrupted());

//
//        Thread java.thread = new MyThread();
//        java.thread.start();
//        try {
//            Thread.sleep(2000);
//            java.thread.interrupt();
//
//            System.out.println("stop 1??" + java.thread.interrupted());
//            System.out.println("stop 2??" + java.thread.interrupted());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 500000; i++) {
                i++;
// System.out.println("i="+(i+1));
            }
        }
    }
}


