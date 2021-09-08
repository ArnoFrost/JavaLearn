package patterns.creational.single;

public class Singleton {
    static {
        System.out.println("Singleton 的静态块");
    }

    {
        System.out.println("Singleton 的普通块");
    }

    public static String name = "fdsfds";
    private String name2 = "fdsfds";

    public static class SingletonHolder {
        {
            System.out.println("SingletonHolder被加载了");
        }

        static {
            System.out.println("static SingletonHolder被加载了");
        }

        String test = name;
        //String test2 = name2
        private static final Singleton INSTANCE = new Singleton();

        public SingletonHolder() {
            System.out.println("============= 我是一个内部类'SingletonHolder' =============");
        }
    }

    public class SingletonHolder2 {
        {
            System.out.println("SingletonHolder2被加载了");
        }

        String test = name;
        String test2 = name2;
        private final Singleton INSTANCE2 = new Singleton();

        public SingletonHolder2() {
            System.out.println("============= 我是一个内部类'SingletonHolder2' =============");
        }
    }

    //  private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}