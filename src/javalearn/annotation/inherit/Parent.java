/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.annotation.inherit;

/**
 * 父类
 *
 * @author crazy
 */
@InheritedTest("使用Inherited的注解 class")
@InheritedTest2("未使用Inherited的注解 class")
public class Parent {

    @InheritedTest("使用Inherited的注解 method")
    @InheritedTest2("未使用Inherited的注解 method")
    public void method() {

    }

    @InheritedTest("使用Inherited的注解 method2")
    @InheritedTest2("未使用Inherited的注解 method2")
    public void method2() {

    }

    @InheritedTest("使用Inherited的注解 field")
    @InheritedTest2("未使用Inherited的注解 field")
    public String a;
}