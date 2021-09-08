package patterns.creational.singleInstance;

/**
 * @author ArnoFrost
 * @date 2020/7/31 18:07
 * @since 1.0
 */
public class LazyThreadSafe {
    private static LazyThreadSafe INSTANCE;

    private LazyThreadSafe() {

    }

    public static LazyThreadSafe getInstance() {
        synchronized (LazyThreadSafe.class) {
            if (INSTANCE == null) {
                INSTANCE = new LazyThreadSafe();
            }
        }
        return INSTANCE;
    }
}
