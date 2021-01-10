package decor;

public class TestDecor {
    public static void main(String[] args) {
        ComponentChild componentChild = new ComponentChild();
        ComponentDecorator decorator = new ComponentDecorator(componentChild);
        decorator.operate1();
    }

}
