/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ArnoFrost
 * @date 2020/7/23 09:59
 * @since 1.0
 */
public class CASLearn {
    static AtomicInteger num = new AtomicInteger(6);

    public static void main(String[] args) {

//        System.out.println(num.compareAndSet(6, 7) + "\t current num:" + num);
//        System.out.println(num.compareAndSet(6, 7) + "\t current num:" + num);
//
//        System.out.println(num.getAndAdd(10) + "\t current num:" + num);

        TestRunnable a = new TestRunnable();
        TestRunnable b = new TestRunnable();

        new Thread(a);
        new Thread(b);
    }

    public Unsafe getUnsafeDefault() {
        return Unsafe.getUnsafe();
    }

    public Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    static class TestRunnable implements Runnable {

        @Override
        public void run() {
            num.getAndAdd(10);
            System.out.println(num.get());
        }
    }
}
