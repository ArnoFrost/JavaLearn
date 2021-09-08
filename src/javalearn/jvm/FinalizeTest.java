/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.jvm;

/**
 * @author ArnoFrost
 * @date 2020/5/19 19:02
 * @since 1.0
 */
public class FinalizeTest {
    private boolean closed = false;

    void close() {
        this.closed = true;
    }

    @Override
    protected void finalize() throws Throwable {
        if (!closed) {//如果该书没有被签入，
            System.out.println("Error: A File was not closed . Name:" + this);
            this.closed = true;
        }
    }

    public static void main(String[] args) {
        FinalizeTest test = new FinalizeTest();
        new FinalizeTest();
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
