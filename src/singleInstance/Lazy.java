package singleInstance;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/31 18:06
 * @Version 1.0
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
