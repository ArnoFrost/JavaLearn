package patterns.creational.single;

/**
 * @author ArnoFrost
 * @date 2020/4/15 16:52
 * @since 1.0
 */
public class Lazy {
    private static Lazy instance;

    private Lazy() {

    }

    //确保线程安全
    public static synchronized Lazy getInstance() {
        if (instance == null) {
            instance = new Lazy();
        }
        return instance;
    }
}
