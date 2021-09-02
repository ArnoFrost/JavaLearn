package java.lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/23 11:49
 * @Version 1.0
 */
public class ReEntrantLock {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        //判断线程是否是当前线程,只有不同线程才会等待
        while (isLocked && thread != lockedBy) {
            wait();
        }
        isLocked = true;
        //如果有重入则记录增加1
        lockedCount++;
        //记录锁住的线程
        lockedBy = thread;

        System.out.println("do lock() java.thread = " + lockedBy.getName() + ",lockedCount = " + lockedCount);
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            System.out.println("do unlock() java.thread = " + lockedBy.getName() + ",lockedCount = " + lockedCount);
            //释放锁过程要看所有加锁的地方都释放掉才释放
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }
}
