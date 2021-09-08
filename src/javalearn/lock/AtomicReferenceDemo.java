/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.lock;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User tom = new User("tom", 18);
        User jim = new User("jim", 20);

        AtomicReference<User> user = new AtomicReference<>();
        user.set(tom);

        System.out.println(user.compareAndSet(tom, jim) + "\t" + user.get().toString());
        System.out.println(user.compareAndSet(tom, jim) + "\t" + user.get().toString());

    }
}

class User {
    String name;
    int age;

    public User(String tom, int i) {
    }
}