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
 * @date 2020/7/23 11:42
 * @since 1.0
 */
public class ReEntrantLearn {
    //    NotReEntrantLock lock = new NotReEntrantLock();
    ReEntrantLock lock = new ReEntrantLock();

    public static void main(String[] args) {
        ReEntrantLearn learn = new ReEntrantLearn();
        try {
            learn.methodA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                learn.methodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void methodA() throws InterruptedException {
        System.out.println("ReEntrantLearn.methodA");
        lock.lock();
//         ...........;
        methodB();
//         ...........;
        lock.unlock();
        System.out.println("ReEntrantLearn.methodA finished");

    }

    public void methodB() throws InterruptedException {
        System.out.println("ReEntrantLearn.methodB");
        lock.lock();
//         ...........;
        lock.unlock();
        System.out.println("ReEntrantLearn.methodB finished");
    }
}
