package patterns.behavioral.responsibility;

/**
 * @author ArnoFrost
 * @since 2021/9/14 11:24
 * 责任链模式 通用处理器
 */
public abstract class AbsHandler {
    private AbsHandler nextHandler;

    public AbsHandler() {
    }

    /**
     * 创建处理器
     *
     * @param nextHandler 下一个处理器
     */
    public AbsHandler(AbsHandler nextHandler) {
        this.nextHandler = nextHandler;
    }


    public final void handleRequest(Request request) {
        // 如果处理等级相同则进行处理
        if (getCurLevel() == request.getRequestLevel()) {
            handle(request);
        }else {
            //否则执行交给下面处理
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("无人处理");
            }
        }

    }

    /**
     * 处理任务
     *
     * @param request 处理任务
     */
    protected abstract void handle(Request request);


    /**
     * 当前处理器等级
     *
     * @return level
     */
    protected abstract int getCurLevel();
}
