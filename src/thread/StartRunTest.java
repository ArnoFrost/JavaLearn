package thread;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/31 16:21
 * @Version 1.0
 */
public class StartRunTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());

        thread1.start();
        thread2.run();
        thread2.start();
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("thread Name = " + Thread.currentThread().getName());
        }
    }
}
