package lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/29 20:08
 * @Version 1.0
 */
public class LearnSingle {
    public void doAdd(int value) {
        final int[] i = {value};
        System.out.println(Thread.currentThread().getName());
        System.out.println("i = " + i[0]);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "started");
                for (int j = 0; j < 100000; j++) {
                    i[0] += value;
                }
                System.out.println(Thread.currentThread().getName() + "finished true i = " + i[0]);
            }
        });
        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "finished i = " + i[0]);
    }
}
