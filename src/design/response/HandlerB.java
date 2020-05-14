package design.response;

public class HandlerB extends Handler {
    public HandlerB() {
    }

    public HandlerB(Handler mNextHandler) {
        super(mNextHandler);
    }

    @Override
    protected void handle(Request request) {
        System.out.println("B 处理");
    }

    @Override
    protected int getCurLevel() {
        return 10;
    }
}
