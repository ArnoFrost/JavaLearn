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
 * @date 2020/7/23 11:49
 * @since 1.0
 */
public class ReEntrantLock {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        //判断线程是否是当前线程,只有不同线程才会等待
        while (isLocked && thread != lockedBy) {
            wait();
        }
        isLocked = true;
        //如果有重入则记录增加1
        lockedCount++;
        //记录锁住的线程
        lockedBy = thread;

        System.out.println("do lock() java.thread = " + lockedBy.getName() + ",lockedCount = " + lockedCount);
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            System.out.println("do unlock() java.thread = " + lockedBy.getName() + ",lockedCount = " + lockedCount);
            //释放锁过程要看所有加锁的地方都释放掉才释放
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }
}
