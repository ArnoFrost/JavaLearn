package patterns.creational.single;

/**
 * @author ArnoFrost
 * @date 2020/4/15 16:54
 * @since 1.0
 */
public class DoubleCheck {
    public DoubleCheck() {

    }

    private volatile static DoubleCheck instance;

    public static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
