package patterns.creational.singleInstance;

/**
 * @author ArnoFrost
 * @date 2020/7/31 18:06
 * @since 1.0
 */
public class Lazy {
    private static Lazy INSTANCE;

    private Lazy() {

    }

    public static Lazy getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Lazy();
        }
        return INSTANCE;
    }
}
