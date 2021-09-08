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
 * @date 2020/7/31 16:21
 * @since 1.0
 */
public class StartRunTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());

        thread1.start();
        thread2.run();
        thread2.start();
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("java.thread Name = " + Thread.currentThread().getName());
        }
    }
}
