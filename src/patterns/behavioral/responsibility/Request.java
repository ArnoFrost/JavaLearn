package patterns.behavioral.responsibility;

/**
 * @author ArnoFrost
 * @since 2021/9/14 11:24
 * 责任链模式 处理任务
 */
public class Request {

    private int level = 0;

    public Request() {
    }

    public Request(int level) {
        this.level = level;
    }

    /**
     * 获得当前层级
     *
     * @return level
     */
    public int getRequestLevel() {
        return level;
    }
}
