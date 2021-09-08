/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.lock;

/**
 * @author ArnoFrost
 * @date 2020/7/29 20:08
 * @since 1.0
 */
public class LearnSingle {
    public void doAdd(int value) {
        final int[] i = {value};
        System.out.println(Thread.currentThread().getName());
        System.out.println("i = " + i[0]);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "started");
                for (int j = 0; j < 100000; j++) {
                    i[0] += value;
                }
                System.out.println(Thread.currentThread().getName() + "finished true i = " + i[0]);
            }
        });
        thread.start();
//        try {
//            java.thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "finished i = " + i[0]);
    }
}
