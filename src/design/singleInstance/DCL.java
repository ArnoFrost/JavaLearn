package design.singleInstance;

/**
 * @author ArnoFrost
 * @date 2020/7/31 18:08
 * @since 1.0
 */
public class DCL {
    private static volatile DCL INSTANCE;

    private DCL() {

    }

    public static DCL getInstance() {
        if (INSTANCE == null) {
            synchronized (DCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }
}
