package patterns.behavioral.response;

public class HandlerTest {
    public static void main(String[] args) {
        RequestA requestA = new RequestA();

        Handler handlerB = new HandlerB();
        Handler handlerA = new HandlerA(handlerB);

        handlerA.handleRequest(requestA);


    }
}
