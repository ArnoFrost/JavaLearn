/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerPattern {

    public static void main(String args[]) {

        //Creating shared object
//        BlockingQueue<Object> sharedQueue = new LinkedBlockingQueue<>(1);
//        BlockingQueue<Object> sharedQueue = new SynchronousQueue<>(true);
        BlockingQueue<Object> sharedQueue = new ArrayBlockingQueue<>(2, true);

//        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));
//
//        //Starting producer and Consumer java.thread
        prodThread.start();
        consThread.start();

    }

}

//Producer Class in java
class Producer implements Runnable {

    private final BlockingQueue<Object> sharedQueue;

    public Producer(BlockingQueue<Object> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Produced: >>>>>>" + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Produced >>>>>> final: ");
        try {
            sharedQueue.put(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

//Consumer Class in Java
class Consumer implements Runnable {

    private final BlockingQueue<Object> sharedQueue;

    public Consumer(BlockingQueue<Object> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = (int) sharedQueue.take();
                System.out.println("Consumed: <<<<<< " + value);
                if (value < 0) {
                    System.out.println("Consumed:finished shutdown");
                    return;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}