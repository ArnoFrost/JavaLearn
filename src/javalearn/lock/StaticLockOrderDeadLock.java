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
 * @date 2020/7/22 20:32
 * @since 1.0
 * 静态的所顺序死锁
 */
public class StaticLockOrderDeadLock {
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void a() {
        try {
            System.out.println("a running");
            synchronized (lockA) {
                System.out.println("a lock lockA");
                Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                synchronized (lockB) {
                    System.out.println("a lock lockB");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        try {
            System.out.println("b running");
            synchronized (lockB) {
                System.out.println("b lock lockB");
                Thread.sleep(3000);
                synchronized (lockA) {
                    System.out.println("b lock lockA");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bNotLock() {
        try {
            System.out.println("b running");
            synchronized (lockA) {
                System.out.println("b lock lockA");
                Thread.sleep(3000);
                synchronized (lockB) {
                    System.out.println("b lock lockB");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
