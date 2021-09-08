/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.thread;

import java.util.concurrent.Callable;

/**
 * @author zejian
 * @time 2016年3月15日 下午2:02:42
 * @decrition Callable接口实例
 */
public class CallableDemo implements Callable<Integer> {

    private int sum;

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable子线程开始计算啦！");

        while (!Thread.interrupted()) {
            for (int i = 0; i < 5000; i++) {
                Thread.sleep(1);
                sum = sum + i;
            }
            System.out.println("Callable子线程计算结束！");
            return sum;
        }

        return null;

    }
} 