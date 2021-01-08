package lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/8/14 09:59
 * @Version 1.0
 */
public class NoEntryLock {
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
