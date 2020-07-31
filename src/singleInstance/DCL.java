package singleInstance;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/31 18:08
 * @Version 1.0
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
