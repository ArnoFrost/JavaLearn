/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author ArnoFrost
 * @date 2021/1/8 11:33
 * @since 1.0
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
