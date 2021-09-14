package patterns.behavioral.responsibility;
/**
 * @author ArnoFrost
 * @since 2021/9/14 11:24
 * 责任链模式 处理器A
 */
public class HandlerA extends AbsHandler {
    public static final int LEVEL_A = 6;
    public HandlerA() {
    }

    public HandlerA(AbsHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected void handle(Request request) {
        System.out.println("A 进行处理");
    }

    @Override
    protected int getCurLevel() {
        return LEVEL_A;
    }
}
