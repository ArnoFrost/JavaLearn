/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ArnoFrost
 * @date 2020/5/13 20:08
 * @since 1.0
 */
public class OddTest {
    private volatile static int count = 0;
    private volatile static boolean flag = true;

    public static void main(String[] args) {
//        doByReEntrant();
        doBySync();
//        doByAtomicInteger();
//        doByExecutor();
    }

    private static int reCount = 0;
    private static final ReentrantLock reentrantLock = new ReentrantLock();
    private static final Condition condition1 = reentrantLock.newCondition();
    private static final Condition condition2 = reentrantLock.newCondition();


    private static void doByReEntrant() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            while (reCount <= 100) {
                try {
                    reentrantLock.lock();
                    System.out.println("偶数 " + reCount++);
                    //阻塞偶数
                    condition1.await(3000, TimeUnit.SECONDS);
                    //唤起奇数
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });

        executorService.execute(() -> {
            while (reCount <= 100) {
                try {
                    reentrantLock.lock();
                    System.out.println("奇数 " + reCount++);
                    condition1.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });

        executorService.shutdown();
    }

    private static int countSync = 0;
    private static final Object lock = new Object();

    private static void doBySync() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            while (countSync <= 100) {
                synchronized (lock) {
                    try {
                        System.out.println("偶数 " + countSync++);
                    } finally {
                        lock.notifyAll();
                        if (countSync <= 100) {
                            try {
                                //防止继续运行
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        });

        executorService.execute(() -> {
            while (countSync <= 100) {
                synchronized (lock) {
                    try {
                        System.out.println("奇数 " + countSync++);
                    } finally {
                        lock.notifyAll();
                        if (countSync < 100) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        executorService.shutdown();
    }

    private static final AtomicInteger atomicCount = new AtomicInteger(0);
    private static final AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    private static void doByAtomicInteger() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            while (atomicCount.get() <= 100) {
                if (atomicBoolean.get()) {
                    System.out.println("偶数 " + atomicCount.getAndIncrement());
                    atomicBoolean.compareAndSet(true, false);
                }
            }
        });

        executorService.execute(() -> {
            while (atomicCount.get() <= 100) {
                if (!atomicBoolean.get()) {
                    System.out.println("奇数 " + atomicCount.getAndIncrement());
                    atomicBoolean.compareAndSet(false, true);
                }
            }
        });
        executorService.shutdown();
    }

    private static void doByExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            while (count <= 100) {
                if (flag) {
                    System.out.println("偶数 " + count++);
                    flag = false;
                }
            }
        });

        executorService.execute(() -> {
            while (count <= 100) {
                if (!flag) {
                    System.out.println("奇数 " + count++);
                    flag = true;
                }
            }
        });
        executorService.shutdown();
    }
}
