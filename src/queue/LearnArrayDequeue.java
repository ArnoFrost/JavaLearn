package queue;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * @Author: ArnoFrost
 * @Date: 2020/8/3 12:01
 * @Version 1.0
 */
public class LearnArrayDequeue {
    public static void main(String[] args) {
//        addFirstAddLastPollFirstPollLast();
//        addFirstPollLast();
//        addFirstPollFirst();
//        addFirstIterator();
        testFloor();
    }

    private static void testFloor() {
        int test = 5 / 2;
        System.out.println(test);
    }

    /**
     * 入队：addFirst
     * 出队：pollLast
     * 效果：先进先出
     */
    private static void addFirstAddLastPollFirstPollLast() {

        StringBuilder sb = new StringBuilder();
        sb.append("addFirstAddLastPollFirstPollLast\n");

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 0) {

                //如果i是偶数从队头加入，否则从队尾加入
                aDeque.addFirst(arr[i]);
            } else {

                aDeque.addLast(arr[i]);
            }
        }

        sb.append("ArrayDeque: " + aDeque.toString());
        sb.append("\n");

        while (!aDeque.isEmpty()) {

            Integer result = aDeque.pollFirst();
            sb.append(result);

            //此处不严谨但是由于arr的元素恰好是偶数个，本例中也不会出现问题。
            result = aDeque.pollLast();
            if (result != null) {
                sb.append(result);
            }
        }

        System.out.println(sb.toString());

    }


    /**
     * 入队：addFirst
     * 出队：pollLast
     * 效果：先进先出
     */
    private static void addFirstPollLast() {

        StringBuilder sb = new StringBuilder();
        sb.append("addFirstPollLast\n");

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        //从双端队列的头部加元素
        for (int i = 0; i < arr.length; i++) {

            aDeque.addFirst(arr[i]);
        }

        sb.append("ArrayDeque: " + aDeque.toString());
        sb.append("\n");

        while (!aDeque.isEmpty()) {
            int result = aDeque.pollLast();
            sb.append(result);
        }

        System.out.println(sb.toString());
    }


    /**
     * 入队：addFirst
     * 出队：pollFirst
     * 效果：先进后出
     */
    private static void addFirstPollFirst() {

        StringBuilder sb = new StringBuilder();
        sb.append("addFirstPollFirst\n");

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        //从双端队列的头部加元素
        for (int i = 0; i < arr.length; i++) {

            aDeque.addFirst(arr[i]);
        }

        sb.append("ArrayDeque: " + aDeque.toString());
        sb.append("\n");

        while (!aDeque.isEmpty()) {
            int result = aDeque.pollFirst();
            sb.append(result);
        }

        System.out.println(sb.toString());
    }


    /**
     * 入队：addFirst
     * 出队：iterator.next()
     * 效果：先进后出
     */
    private static void addFirstIterator() {

        StringBuilder sb = new StringBuilder();
        sb.append("addFirstIterator\n");

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        //从双端队列的头部加元素
        for (int i = 0; i < arr.length; i++) {

            aDeque.addFirst(arr[i]);
        }

        sb.append("ArrayDeque: " + aDeque.toString());
        sb.append("\n");

        for (Iterator<Integer> iterator = aDeque.iterator(); iterator.hasNext(); ) {

            int result = iterator.next();
            sb.append(result);
        }

        System.out.println(sb.toString());
    }
}
