package lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/23 11:42
 * @Version 1.0
 */
public class ReEntrantLearn {
    //    NotReEntrantLock lock = new NotReEntrantLock();
    ReEntrantLock lock = new ReEntrantLock();

    public static void main(String[] args) {
        ReEntrantLearn learn = new ReEntrantLearn();
        try {
            learn.methodA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                learn.methodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void methodA() throws InterruptedException {
        System.out.println("ReEntrantLearn.methodA");
        lock.lock();
//         ...........;
        methodB();
//         ...........;
        lock.unlock();
        System.out.println("ReEntrantLearn.methodA finished");

    }

    public void methodB() throws InterruptedException {
        System.out.println("ReEntrantLearn.methodB");
        lock.lock();
//         ...........;
        lock.unlock();
        System.out.println("ReEntrantLearn.methodB finished");
    }
}
