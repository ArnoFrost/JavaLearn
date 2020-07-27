package lock; // ABA问题及解决方式

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {

    private static final AtomicReference<String> atomicReference = new AtomicReference<>("A");
    private static final AtomicStampedReference<String> stampReference = new AtomicStampedReference<>("A", 1);

    public static void main(String[] args) {
        new Thread(() -> {
            //获取到版本号
            int stamp = stampReference.getStamp();
            System.out.println("t1获取到的版本号：" + stamp);
            try {
                //暂停1秒,确保t1,t2版本号相同
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet("A", "B");
            atomicReference.compareAndSet("B", "A");

            stampReference.compareAndSet("A", "B", stamp, stamp + 1);
            stampReference.compareAndSet("B", "A", stamp + 1, stamp + 2);
            System.out.println("t1线程ABA之后的版本号：" + stampReference.getStamp());

        }, "t1").start();

        new Thread(() -> {
            //获取到版本号
            int stamp = stampReference.getStamp();
            System.out.println("t2获取到的版本号：" + stamp);
            try {
                //暂停2秒,等待t1执行完成ABA
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("普通原子类无法解决ABA问题： ");
            System.out.println(atomicReference.compareAndSet("A", "C") + "\t" + atomicReference.get());
            System.out.print("版本号的原子类解决ABA问题： ");
            System.out.println(stampReference.compareAndSet("A", "C", stamp, stamp + 1) + "\t" + stampReference.getReference());

        }, "t2").start();
    }
}