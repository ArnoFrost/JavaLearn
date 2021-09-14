package patterns.behavioral.responsibility;

/**
 * @author ArnoFrost
 * @since 2021/9/14 11:24
 * 责任链模式 处理器B
 */
public class HandlerC extends AbsHandler {
    public static final int LEVEL_C = 15;

    public HandlerC() {
    }

    public HandlerC(AbsHandler handler) {
        super(handler);
    }

    @Override
    protected void handle(Request request) {
        System.out.println("C 进行处理");
    }

    @Override
    protected int getCurLevel() {
        return LEVEL_C;
    }
}
