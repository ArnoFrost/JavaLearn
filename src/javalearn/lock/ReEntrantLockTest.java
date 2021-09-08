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
 * @date 2020/5/13 19:38
 * @since 1.0
 */
public class ReEntrantLockTest {
    //    NoEntryLock lock = new NoEntryLock();
    ReEntrantLock lock = new ReEntrantLock();

    public static void main(String[] args) {
        ReEntrantLockTest entrant = new ReEntrantLockTest();
        try {
            entrant.setA();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    synchronized void setA() throws Exception {
        lock.lock();
        System.out.println("set A");
        Thread.sleep(1000);
        setB();
        System.out.println("set A finished");
        lock.unlock();
    }

    synchronized private void setB() throws Exception {
        lock.lock();
        System.out.println("set B");
        Thread.sleep(1000);
        System.out.println("set B finished");
        lock.unlock();
    }
}
