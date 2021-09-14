package patterns.behavioral.responsibility;
/**
 * @author ArnoFrost
 * @since 2021/9/14 11:24
 * 责任链模式 处理器B
 */
public class HandlerB extends AbsHandler {
    public static final int LEVEL_B = 10;

    public HandlerB() {
    }

    public HandlerB(AbsHandler mNextHandler) {
        super(mNextHandler);
    }

    @Override
    protected void handle(Request request) {
        System.out.println("B 进行处理");
    }

    @Override
    protected int getCurLevel() {
        return LEVEL_B;
    }
}
