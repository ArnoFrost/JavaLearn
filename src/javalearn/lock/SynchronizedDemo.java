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
 * @date 2021/1/12 15:40
 * @since 1.0
 */
public class SynchronizedDemo {
    private final Object object = new Object();

    public void synSay1() {
        synchronized (object) {
            System.out.println("synSay1----" + Thread.currentThread().getName());
        }
    }

    synchronized public void synSay2() {
        System.out.println("synSay2----" + Thread.currentThread().getName());
    }
}
