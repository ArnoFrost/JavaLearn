package sys;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/21 17:44
 * @Version 1.0
 */
public class LoadClass {
    public static class SuperClass {
        static {
            System.out.println("SuperClass static init");
        }

        //不添加final 则执行初始化
//        public static String ABC = "abc";
        //final 则不用进行初始化
        public final static String ABC = "abc";
    }

    public static class SubClass extends SuperClass {
        static {
            System.out.println("SubClass static init");
        }
    }

    public static void main(String[] args) {
        //调用静态变量则只有直接声明的字段类才会初始化
        System.out.println(SubClass.ABC);
    }
}
