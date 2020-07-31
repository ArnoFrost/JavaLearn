package lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/20 14:12
 * @Version 1.0
 */
public class LearnLock {
    public static void main(String[] args) {
        testSyncLock();
//        testSpinLock();
    }

    private static void testSpinLock() {
        SpinLock lock = new SpinLock();
        Thread threadA = new Thread(() -> {
            lock.lock();
            System.out.println("thread a lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("thread a unlock");

        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            System.out.println("thread b lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("thread b unlock");

        });

        Thread threadC = new Thread(() -> {
            lock.lock();
            System.out.println("thread c lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("thread c unlock");

        });

        threadA.start();
        threadB.start();
        threadC.start();


        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testSyncLock() {
        final Object a = new Object();
        final Object b = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    try {
                        System.out.println("now i in threadA-lockb");
                        Thread.sleep(1000L);

                        synchronized (a) {
                            System.out.println("now i in threadA-locka");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        System.out.println("now i in threadB-locka");
                        Thread.sleep(1000L);
                        a.wait(1000L);

                        synchronized (b) {
                            System.out.println("now i in threadB-lockb");
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
