package java.thread;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/21 14:06
 * @Version 1.0
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cacheThreadPool = getCacheThreadPool();
        //测试线程池特性
        for (int i = 0; i < 10; i++) {
            TestRunnable runnable = new TestRunnable();
            cacheThreadPool.execute(runnable);
        }
        //最大并发数为5
        ExecutorService fixedThreadPool = getFixedThreadPool(5);
        //测试线程池特性
        for (int i = 0; i < 10; i++) {
            TestRunnable runnable = new TestRunnable();
            fixedThreadPool.execute(runnable);
        }

        System.out.println("finished");
        Thread.yield();
    }

    static class TestRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(new Random(System.currentTimeMillis()).nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do finished " + Thread.currentThread().getName());
        }
    }

    /**
     * 适合执行短周期的任务
     * 在每次任务创建时如果没有空闲线程则会创建一个新的线程
     * 在空闲周期后如果没有活动会销毁线程
     * 一般情况任务会一直挤压,不会有拒绝产生
     *
     * @return
     */
    private static ExecutorService getCacheThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                5L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>()
                , getCustomThreadFactory());
    }

    /**
     * 创建可重用但最大值固定的线程池
     * 每次有新任务进来如果不满足最大线程则创建新的线程,
     * 多余的任务会放入队列等待
     * 空闲线程不会销毁
     * 一般情况任务会一直挤压,不会有拒绝产生
     *
     * @param threads
     * @return
     */
    private static ExecutorService getFixedThreadPool(int threads) {
        return new ThreadPoolExecutor(threads, threads,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>()
                , getCustomThreadFactory());
    }

    /**
     * 区别与fixedThreadpool 设定为1不同
     * 内部实现是通过代理类
     *
     * @return
     * @see Executors#finalize()
     */
    private static ExecutorService getSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    private static ThreadFactory getCustomThreadFactory() {
        return new DefaultThreadFactory();
    }

    /**
     * The default java.thread factory.
     */
    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "group-" + group.getName() +
                    "-pool-" +
                    poolNumber.getAndIncrement() +
                    "-java.thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
