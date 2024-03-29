/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.annotation.notnull;

/**
 * @program: demo
 * @description:
 * @author wwh
 * @create: 2019-01-16 14:40
 **/
public class Person {

    @NotNull(fileName = "姓名")
    private String name;
    @NotNull(fileName = "年龄")
    private String age;

    /**
     * 获取 @NotNull(fileName = "姓名")
     *
     * @return name @NotNull(fileName = "姓名")
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 @NotNull(fileName = "姓名")
     *
     * @param name @NotNull(fileName = "姓名")
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 @NotNull(fileName = "年龄")
     *
     * @return age @NotNull(fileName = "年龄")
     */
    public String getAge() {
        return this.age;
    }

    /**
     * 设置 @NotNull(fileName = "年龄")
     *
     * @param age @NotNull(fileName = "年龄")
     */
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

