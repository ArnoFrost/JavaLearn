package java.lock;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/12 15:40
 * @Version 1.0
 */
public class SynchronizedDemo {
    private final Object object = new Object();

    public void synSay1() {
        synchronized (object) {
            System.out.println("synSay1----" + Thread.currentThread().getName());
        }
    }

    synchronized public void synSay2() {
        System.out.println("synSay2----" + Thread.currentThread().getName());
    }
}
