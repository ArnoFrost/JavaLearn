package patterns.behavioral.responsibility;

/**
 * @author ArnoFrost
 * @since 2021/9/14 11:24
 * 责任链模式 Demo
 */
public class ResponsibilityPatternDemo {
    public static void main(String[] args) {
        //HandlerB.LEVEL_B,HandlerC.LEVEL_C
//        int level = HandlerC.LEVEL_C;
        int level = HandlerC.LEVEL_C + 1;
        Request request = new Request(level);

        //自下而上创建责任链
        AbsHandler handlerC = new HandlerC();
        AbsHandler handlerB = new HandlerB(handlerC);
        AbsHandler handlerTop = new HandlerA(handlerB);
        //顶端处理器处理任务
        handlerTop.handleRequest(request);


    }
}
