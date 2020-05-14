package design.response;

public abstract class Handler {
    private Handler mNextHandler;

    public Handler() {

    }

    public Handler(Handler mNextHandler) {
        this.mNextHandler = mNextHandler;
    }


    public final void handleRequest(Request request) {
        if (getCurLevel() == request.getRequestLevel()) {
            handle(request);
        } else {
            if (mNextHandler != null) {
                mNextHandler.handleRequest(request);
            } else {
                System.out.println("无人处理");
            }
        }
    }

    protected abstract void handle(Request request);


    protected abstract int getCurLevel();
}
