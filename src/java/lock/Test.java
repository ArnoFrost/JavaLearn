package java.lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/29 20:10
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        LearnSingle single = new LearnSingle();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                single.doAdd(1);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                single.doAdd(2);
            }
        });

        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
