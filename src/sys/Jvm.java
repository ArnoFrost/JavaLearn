package sys;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/21 15:54
 * @Version 1.0
 */
public class Jvm {
    public static void main(String[] args) {
        testString();
    }

    private static void testString() {
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println("s1 = " + s1);
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja")
                .append("va").toString();
//        String s2 = new StringBuilder("go")
//                .append("od").toString();
        System.out.println("s2 = " + s2 + ",s2.intern = " + s2.intern());
        System.out.println(s2.intern() == s2);
//        System.out.println(s2.intern() == s1);

        String s3 = new StringBuilder("he")
                .append("llo").toString();
        System.out.println(s3.intern() == s3);

//        String s0= "kvill";
//        String s1=new String("kvill");
//        String s2=new String("kvill");
//        System.out.println( s0==s1 );
//        System.out.println("**********" );
//        s1.intern();
//        s2=s2.intern(); //把常量池中“kvill”的引用赋给s2
//        System.out.println( s0==s1);
//        System.out.println( s0==s1.intern() );
//        System.out.println( s0==s2 );
    }
}
