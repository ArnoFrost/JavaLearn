package javalearn.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class LearnReferenceQueue {
    public static void main(String[] args) {
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
        Object value = new Object();
        Map<Object, Object> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[1024 * 1000];
            WeakReference<byte[]> weakReference = new WeakReference<>(bytes, referenceQueue);
            map.put(weakReference, value);
        }
        System.out.println("map.size->" + map.size());
        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> weakReference;
                while ((weakReference = (WeakReference<byte[]>) referenceQueue.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + weakReference);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
