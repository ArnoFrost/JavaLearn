package design.response;

public class HandlerA extends Handler {
    public HandlerA() {
    }

    public HandlerA(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected void handle(Request request) {
        System.out.println("A 进行处理");
    }

    @Override
    protected int getCurLevel() {
        return 6;
    }
}
