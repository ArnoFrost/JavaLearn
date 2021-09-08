/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ArnoFrost
 * @date 2020/5/13 19:44
 * @since 1.0
 * 非公平 自旋锁 简单实现
 */
public class SpinLock {

    private final AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        //利用原子性不断自旋
        //由于自旋锁只是将当前线程不停地执行循环体，不进行线程状态的改变，所以响应速度更快。
        //但当线程数不停增加时，性能下降明显，因为每个线程都需要执行，占用CPU时间。
        //如果线程竞争不激烈，并且保持锁的时间段。适合使用自旋锁。
        while (!sign.compareAndSet(null, current)) {

        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }
}
