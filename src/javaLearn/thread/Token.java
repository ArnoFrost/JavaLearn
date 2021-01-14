package javaLearn.thread;

public class Token {

    private Token() {
    }

    private static class SingletonInstance {
        private static final Token INSTANCE = new Token();
    }

    public static Token getInstance() {
        return SingletonInstance.INSTANCE;
    }
}