/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.lock;

public class testThread implements Runnable {
    Thread th;
    int type;
    SynchronizationObject so;

    public testThread(SynchronizationObject so, int type) {
        this.so = so;
        th = new Thread(this);
        th.start();
        this.type = type;
    }

    @Override
    public void run() {
        if (type == 1)
            so.runSynchronizationMethod1();
        else
            so.runSynchronizationMethod0();
    }

    public static void main(String[] args) {
        SynchronizationObject so = new SynchronizationObject();
        new testThread(so, 1);
        new testThread(so, 0);
    }
}