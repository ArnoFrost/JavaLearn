package design.producter;

import java.util.PriorityQueue;

public class MyProducer {
    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int queueSize = 1;

    public static void main(String[] args) {
        MyProducer myProducer = new MyProducer();
        Producer p = myProducer.new Producer();
        Consumer c = myProducer.new Consumer();

        p.start();
        c.start();
    }

    class Producer extends Thread {
        private int produce = -1;

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        System.out.println("队列已满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (produce >= 20) {
                        return;
                    }
                    queue.offer(produce += 2);
                    queue.notify();
                    System.out.println("P 打印:" + produce);
                }

            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        System.out.println("队列为空等待");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = queue.poll();
                    if (poll != null) {
                        System.out.println("C 打印:" + (poll + 1));
                    }
                    queue.notify();
                }

            }
        }
    }


}
