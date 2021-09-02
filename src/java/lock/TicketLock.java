package java.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/13 19:55
 * @Version 1.0
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
