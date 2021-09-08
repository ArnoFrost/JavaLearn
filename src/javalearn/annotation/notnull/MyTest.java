/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.annotation.notnull;

import javalearn.annotation.ValidateResult;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author wwh
 * @create: 2019-01-16 15:32
 **/
public class MyTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张飞");
        person.setAge("128");
        List<ValidateResult> validate = MyAnnotation.validate(person);
        StringBuilder str = new StringBuilder();
        for (ValidateResult va : validate) {
            if (!va.isValid()) {
                str.append(va.getMessage()).append(",");
            }
        }
        System.err.println(str.toString());
    }
}

