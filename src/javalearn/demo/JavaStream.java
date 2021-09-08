/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ArnoFrost
 * @date 2021/7/9 11:38
 * @since 1.0
 */
public class JavaStream {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static void method1() {
        List<Integer> tempList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = tempList.stream()
                .filter(integer -> {
                    System.out.println("filter integer = " + integer);
                    return integer < 5;
                })
                .map(integer -> {
                    System.out.println("datastruct.map integer = " + integer);
                    return integer * 2;
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Filter collection less than 5");
        System.out.println(collect);
    }

    private static void method2() {
        List<Integer> tempList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> integerStream = tempList.stream()
                .filter(integer -> {
                    System.out.println("filter integer = " + integer);
                    return integer < 5;
                })
                .map(integer -> {
                    System.out.println("datastruct.map integer = " + integer);
                    return integer * 2;
                })
                .limit(2);
        System.out.println("Filter collection less than 5");
        System.out.println(integerStream.collect(Collectors.toList()));
    }
}
