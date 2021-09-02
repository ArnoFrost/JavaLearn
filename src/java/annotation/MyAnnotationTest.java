package java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/8 11:33
 * @Version 1.0
 */
public class MyAnnotationTest {
    public static void main(String[] args) {
        Class<MyAnnotationTest> test = MyAnnotationTest.class;
        // 获取类上的所有注解
        Annotation[] annotations = test.getAnnotations();
        for (Annotation annotation : annotations) {
            // 获取注解的全类名
            System.out.println(annotation.annotationType().getName());
        }

        try {
            Method method = test.getMethod("hello", new Class[]{});

            // hello() 方法上是否有 MyAnnotation 注解
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                // 获得注解
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                // 获取注解的内容
                System.out.println(annotation.name());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @MyAnnotation(name = "name of method")
    public String hello() {
        return "hello";
    }
}
