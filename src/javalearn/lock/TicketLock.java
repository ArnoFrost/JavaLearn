/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ArnoFrost
 * @date 2020/5/13 19:55
 * @since 1.0
 */
public class TicketLock {
    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();
    private static final ThreadLocal<Integer> LOCAL = new ThreadLocal<>();

    public void lock() {
        int myTicket = ticketNum.getAndIncrement();
        LOCAL.set(myTicket);
        while (myTicket != serviceNum.get()) {

        }
    }

    public void unlock() {
        int myTicket = LOCAL.get();
        serviceNum.compareAndSet(myTicket, myTicket + 1);
    }
}
