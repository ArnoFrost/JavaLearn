package java.lock;

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