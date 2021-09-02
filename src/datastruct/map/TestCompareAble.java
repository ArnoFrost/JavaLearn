package datastruct.map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/17 14:53
 * @Version 1.0
 */
public class TestCompareAble {
    public static final int MAX_LOOP = 5000000;
    public static final int HASH_CODE = 9999;

    public static void main(String[] args) {
        //时间打印1
        long normalStart = System.currentTimeMillis();
        //普通Food
        Map<Food, String> normalMap = new HashMap<>();
        Food normalFood = null;
        for (int i = 0; i < MAX_LOOP; i++) {
            UUID uuid = UUID.randomUUID();
            normalFood = new Food("Arno" + i, 100, uuid);
            normalMap.put(normalFood, "test : " + i);
        }
        if (normalMap.get(normalFood) != null) {
            System.out.println("normal not null");
        }
        long normalEnd = System.currentTimeMillis();
        System.out.println("normal time = " + (normalEnd - normalStart));

        //时间打印2
        long compareStart = System.currentTimeMillis();
        //实现ComparableFood
        Map<Food2, String> compareMap = new HashMap<>();
        Food2 compareFood = null;
        for (int i = 0; i < MAX_LOOP; i++) {
            UUID uuid = UUID.randomUUID();
            compareFood = new Food2("Arno" + i, 100, uuid);
            compareMap.put(compareFood, "test : " + i);
        }

        if (compareMap.get(compareFood) != null) {
            System.out.println("compare not null");
        }
        long compareEnd = System.currentTimeMillis();
        System.out.println("compare time = " + (compareEnd - compareStart));

    }

    static class Food2 implements Comparable<Food2> {
        private UUID uuid;
        private String name;
        private int price;

        public Food2(String name, int price, UUID uuid) {
            this.name = name;
            this.price = price;
            this.uuid = uuid;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Food2 food2 = (Food2) o;
            return price == food2.price &&
                    name.equals(food2.name) &&
                    uuid.equals(food2.uuid);
        }

        @Override
        public int hashCode() {
//            return Objects.datastruct.hash(name, price, uuid);
            return HASH_CODE;
        }

        @Override
        public int compareTo(Food2 o) {
            return this.name.compareTo(o.name);
        }
    }

    static class Food implements Comparable<Food> {
        private String name;
        private int price;
        private UUID uuid;

        public Food(String name, int price, UUID uuid) {
            this.name = name;
            this.price = price;
            this.uuid = uuid;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Food food = (Food) o;
            return price == food.price &&
                    name.equals(food.name) &&
                    uuid.equals(food.uuid);
        }

        @Override
        public int hashCode() {
//            return Objects.datastruct.hash(name, price, uuid);
            return HASH_CODE;
        }

        @Override
        public int compareTo(Food o) {
            return this.uuid.compareTo(o.uuid);
        }
    }
}
