package datastruct.hash;

import java.util.*;

/**
 * @author ArnoFrost
 * @date 2020/7/29 14:06
 * @since 1.0
 */
public class LearnHash {
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    public static void main(String[] args) {
        Person personA = new Person("Arno", 25);
        Person personAPlus = new Person("Arno", 25);

        System.out.println(personA.equals(personAPlus));
    }

    private void test() {
        Hashtable<Integer, Integer> hashtable = getHashTable();
        HashMap<Integer, Integer> hashMap = getHashMap();

        new Thread(() -> {
//                Iterator<Map.Entry<Integer, Integer>> mapItr = hashMap.entrySet().iterator();
//                while (mapItr.hasNext()) {
//                    Map.Entry<Integer, Integer> entry = mapItr.next();
//                    System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
//                }
            for (int i = 100; i < 1000; i++) {
//                hashMap.put(i, i);
                hashtable.put(i, i);
            }

        }).start();

//        Iterator<Map.Entry<Integer, Integer>> mapItr = hashMap.entrySet().iterator();
//        while (mapItr.hasNext()) {
//            Map.Entry<Integer, Integer> entry = mapItr.next();
//            hashMap.put(entry.getKey(), 10);
//            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
//        }

        Iterator<Map.Entry<Integer, Integer>> tableItr = hashtable.entrySet().iterator();
        while (tableItr.hasNext()) {
            Map.Entry<Integer, Integer> entry = tableItr.next();
            hashtable.put(entry.getKey(), 10);
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

    private static HashMap<Integer, Integer> getHashMap() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            hashMap.put(i, i);
        }

        return hashMap;
    }

    private static Hashtable<Integer, Integer> getHashTable() {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < 10; i++) {
            hashtable.put(i, i);
        }
        return hashtable;
    }
}
