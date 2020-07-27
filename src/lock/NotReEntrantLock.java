package lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/23 11:45
 * @Version 1.0
 */
public class NotReEntrantLock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
