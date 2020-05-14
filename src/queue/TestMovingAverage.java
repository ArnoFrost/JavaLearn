package queue;

import edu.princeton.cs.algs4.Queue;

public class TestMovingAverage {

    public static void main(String[] args) {
        MovingAverage average = new MovingAverage(3);
        System.out.println(average.next(3));
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));
    }

    static class MovingAverage {
        private Queue<Integer> queue;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            queue = new Queue<>();
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() == size) {
                queue.dequeue();
            }
            queue.enqueue(val);

            int sum = 0;
            for (Integer integer : queue) {
                sum += integer;
            }

            return sum / queue.size();
        }
    }

}
