/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.lock;

public class SynchronizationObject {
    public SynchronizationObject() {
    }

    public synchronized void runSynchronizationMethod0() {
        System.out.println("this is start test0!");
        //该循环的目地只有一个,就是可以使当前方法在一定时间内交出执行线程
        for (int i = 0; i < 10000000; i++) {
        }
        System.out.println("this is end test0!");
    }

    public synchronized void runSynchronizationMethod1() {
        System.out.println("this is start test1!");
        for (int i = 0; i < 10000000; i++) {
        }
        System.out.println("this is end test1!");
    }
}