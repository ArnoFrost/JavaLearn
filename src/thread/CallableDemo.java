package thread;

import java.util.concurrent.Callable;

/**
 * @author zejian
 * @time 2016年3月15日 下午2:02:42
 * @decrition Callable接口实例
 */
public class CallableDemo implements Callable<Integer> {

    private int sum;

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable子线程开始计算啦！");

        while (!Thread.interrupted()) {
            for (int i = 0; i < 5000; i++) {
                Thread.sleep(1);
                sum = sum + i;
            }
            System.out.println("Callable子线程计算结束！");
            return sum;
        }

        return null;

    }
} 