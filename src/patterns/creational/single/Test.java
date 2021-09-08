package patterns.creational.single;

import java.util.Vector;

/**
 * @author ArnoFrost
 * @date 2020/4/15 17:40
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Singleton.getInstance();
//        StaticInner.getInstance();
//        Vector<Integer> vector = new Vector<>();
//        // 先存放1000个值让iterator有值可以遍历
//        for (int i = 0; i < 1000; i++) {
//            vector.add(i);
//        }
//
//        Thread iteratorThread = new Thread(new IteratorRunnable(vector));
//        iteratorThread.start();
//
//        // 主线程休眠5秒，让iteratorThread能够充分跑起来。这段时间是不会有问题的。
//        TimeUnit.SECONDS.sleep(5);
//
//        // 该线程启动之后，会结构化修改Vector，然后就会抛出ConcurrentModificationException异常
//        Thread modifyVectorThread = new Thread(new ModifyVectorRunnable(vector));
//        modifyVectorThread.start();


    }

    /**
     * 这个Runnable会不断使用迭代器(for-each语句)遍历Vector
     */
    private static class IteratorRunnable implements Runnable {

        private Vector<Integer> vector;

        public IteratorRunnable(Vector<Integer> vector) {
            this.vector = vector;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (vector) {
                    for (Integer i : vector) {

                    }
                }

            }
        }
    }

    /**
     * 这个Runnable会不断添加新元素，也就是会结构化修改Vector
     */
    private static class ModifyVectorRunnable implements Runnable {
        private Vector<Integer> vector;

        public ModifyVectorRunnable(Vector<Integer> vector) {
            this.vector = vector;
        }

        @Override
        public void run() {
            while (true) {
                vector.add(1);
            }
        }
    }
}
