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
 * @date 2020/7/22 20:33
 * @since 1.0
 */
public class TestDeadLock {
    public static void main(String[] args) {
//        StaticLockOrderDeadLock staticLockOrderDeadLock = new StaticLockOrderDeadLock();
//        new Thread(staticLockOrderDeadLock::a).start();
//        new Thread(staticLockOrderDeadLock::b).start();

        DynamicLockOrderDeadLock dynamicLockOrderDeadLock = new DynamicLockOrderDeadLock();
        DynamicLockOrderDeadLock.Account accountA = new DynamicLockOrderDeadLock.Account(10, "AccountA");
        DynamicLockOrderDeadLock.Account accountB = new DynamicLockOrderDeadLock.Account(100, "AccountB");

//        new Thread(() -> dynamicLockOrderDeadLock.transferMoney(accountA, accountB, 10.0)).start();
//        new Thread(() -> dynamicLockOrderDeadLock.transferMoney(accountB, accountA, 20.0)).start();

        new Thread(() -> dynamicLockOrderDeadLock.transferMoneyNotLock(accountA, accountB, 10.0)).start();
        new Thread(() -> dynamicLockOrderDeadLock.transferMoneyNotLock(accountB, accountA, 20.0)).start();
    }
}
