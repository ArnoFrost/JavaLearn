package datastruct.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/13 11:05
 * @Version 1.0
 */
public class TestQueue {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Producer implements Runnable {

        protected BlockingQueue queue = null;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                queue.put("1");
                Thread.sleep(1000);
                queue.put("2");
                Thread.sleep(1000);
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class Consumer implements Runnable {
        protected BlockingQueue queue = null;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
