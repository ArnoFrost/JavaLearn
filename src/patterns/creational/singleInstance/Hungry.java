package patterns.creational.singleInstance;

/**
 * @author ArnoFrost
 * @date 2020/7/31 18:05
 * @since 1.0
 */
public class Hungry {
    private static Hungry instance = new Hungry();

    private Hungry() {

    }

    public static Hungry getInstance() {
        return instance;
    }
}
