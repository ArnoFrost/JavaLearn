package design.single;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/15 16:50
 * @Version 1.0
 */
public class Hungry {
    private static final Hungry instance = new Hungry();

    private Hungry() {

    }

    public static Hungry getInstance() {
        return instance;
    }
}
