package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ArnoFrost
 * @Date: 2020/8/10 14:23
 * @Version 1.0
 */
public class RunnableTest {

    public static void main(String[] args) {
        BlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(10);
//        ExecutorService myService = Executors.newCachedThreadPool();
//        ExecutorService myService = new ThreadPoolExecutor(3, 10, 5,
//                TimeUnit.SECONDS, linkedBlockingQueue, getDefaultFactory(), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                System.out.println("on Reject " + r.toString());
//            }
//        });∑
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 5,
//                TimeUnit.SECONDS, linkedBlockingQueue, new MyThreadFactory());
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool(new MyThreadFactory());
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 5,
//                TimeUnit.SECONDS, linkedBlockingQueue,Executors.defaultThreadFactory());
        ExecutorService executor = Executors.newScheduledThreadPool(2);

//        executor.allowCoreThreadTimeOut(true);
//        executor.prestartAllCoreThreads();

//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
//        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                System.out.println("do reject" + r.hashCode());
//            }
//        });
//        try {
//            int result = myCallable.call();
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        for (int i = 0; i < 2; i++) {
//            Future<Integer> result = executor.submit(new MyCallable("arno" + i));
//            executor.execute(new MyRunnable("arno" + i));
            executor.execute(new MyFutureTask(new MyCallable("arno" + i)));
//            System.out.println("active count = " + executor.getActiveCount());
//            try {
//                System.out.println("result = " + result.get());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        executor.execute(new MyCallable("arno"));
//        executor.shutdown();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("is terminated = " + executor.isTerminated());

        }
    }


    private static class MyThreadFactory implements ThreadFactory {
        private final AtomicInteger i = new AtomicInteger(1);

        public MyThreadFactory() {
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "threadpool - " + i.getAndIncrement());
            t.setDaemon(false);
            t.setPriority(Thread.NORM_PRIORITY);
            System.out.println(t.getName());
            return t;
        }
    }


    private static class MyRunnable implements Runnable {
        private final String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int result = 1;
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                result += result;
            }
            System.out.println(name);
        }
    }

    private static class MyCallable implements Callable<Integer> {

        private final String name;

        public MyCallable(String name) {
            this.name = name;
        }

        @Override
        public Integer call() throws Exception {
            int result = 1;
            Thread.sleep(1 * 1000);
            for (int i = 0; i < 10; i++) {
                result += result;
            }
            System.out.println(name);
            return result;
        }
    }

    private static class MyFutureTask extends FutureTask<Integer> {

        public MyFutureTask(Runnable runnable, Integer result) {
            super(runnable, result);
        }

        public MyFutureTask(Callable<Integer> callable) {
            super(callable);
        }
    }
}
