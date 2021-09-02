package java.lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/13 19:38
 * @Version 1.0
 */
public class ReEntrantLockTest {
    //    NoEntryLock lock = new NoEntryLock();
    ReEntrantLock lock = new ReEntrantLock();

    public static void main(String[] args) {
        ReEntrantLockTest entrant = new ReEntrantLockTest();
        try {
            entrant.setA();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    synchronized void setA() throws Exception {
        lock.lock();
        System.out.println("set A");
        Thread.sleep(1000);
        setB();
        System.out.println("set A finished");
        lock.unlock();
    }

    synchronized private void setB() throws Exception {
        lock.lock();
        System.out.println("set B");
        Thread.sleep(1000);
        System.out.println("set B finished");
        lock.unlock();
    }
}
