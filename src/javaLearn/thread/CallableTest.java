package javaLearn.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author zejian
 * @time 2016年3月15日 下午2:05:43
 * @decrition callable执行测试类
 */
public class CallableTest {

    public static void main(String[] args) {
        //      //创建线程池
        //      ExecutorService es = Executors.newSingleThreadExecutor();
        //      //创建Callable对象任务
        //      CallableDemo calTask=new CallableDemo();
        //      //提交任务并获取执行结果
        //      Future<Integer> future =es.submit(calTask);
        //      //关闭线程池
        //      es.shutdown();

        //创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //创建Callable对象任务
        CallableDemo calTask = new CallableDemo();
        //创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(calTask);
        //执行任务
        es.execute(futureTask);


        getResult(futureTask);

        //关闭线程池
        es.shutdown();
        System.out.println("主线程在执行完成");
    }

    private static void getResult(FutureTask<Integer> futureTask) {
        try {
            System.out.println("isDone = " + futureTask.isDone() + ", isCancelled = " + futureTask.isCancelled());
            if (futureTask.isDone() && !futureTask.isCancelled()) {
                if (futureTask.get() != null) {
                    //输出获取到的结果
                    System.out.println("futureTask.get()-->" + futureTask.get());
                } else {
                    //输出获取到的结果
                    System.out.println("futureTask.get()未获取到结果");
                }
            } else {
                if (!futureTask.isCancelled()) {
                    System.out.println("没结束 循环");
                    futureTask.cancel(true);
                    Thread.sleep(1000);
                    getResult(futureTask);
                } else {
                    System.out.println("任务被结束");
                }

            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}