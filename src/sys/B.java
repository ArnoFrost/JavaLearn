package sys;

public class B {
    public static B t1 = new B();
    public static B t2 = new B();

    public static void main(String[] args) {
        B t = new B();
    }

    static {
        System.out.println("静态块");
    }

    {
        System.out.println("构造块");
    }
}
