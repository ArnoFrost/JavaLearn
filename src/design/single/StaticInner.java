package design.single;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/15 17:01
 * @Version 1.0
 */
public class StaticInner {
    private static class StaticInnerHolder {
        private static final StaticInner INSTANCE = new StaticInner();
    }

    private StaticInner() {
        System.out.println("do init");
    }

    public static StaticInner getInstance() {
        return StaticInnerHolder.INSTANCE;
    }

}
