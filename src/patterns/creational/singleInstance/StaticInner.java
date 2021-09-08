package patterns.creational.singleInstance;

public class StaticInner {

    private StaticInner() {
    }

    private static class SingletonInstance {
        private static final StaticInner INSTANCE = new StaticInner();
    }

    public static StaticInner getInstance() {
        return SingletonInstance.INSTANCE;
    }
}