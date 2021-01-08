package reflect;

public class Single {

    private Single() {
    }

    private static class SingletonInstance {
        private static final Single INSTANCE = new Single();
    }

    public static Single getInstance() {
        return SingletonInstance.INSTANCE;
    }
}