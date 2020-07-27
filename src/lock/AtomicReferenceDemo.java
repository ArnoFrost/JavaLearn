package lock;

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