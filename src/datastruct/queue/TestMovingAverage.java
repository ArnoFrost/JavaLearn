//package datastruct.queue;
//
//import edu.princeton.cs.algs4.Queue;
//
//public class TestMovingAverage {
//
//    public static void main(String[] args) {
//        MovingAverage average = new MovingAverage(3);
//        System.out.println(average.next(3));
//        System.out.println(average.next(1));
//        System.out.println(average.next(10));
//        System.out.println(average.next(3));
//        System.out.println(average.next(5));
//    }
//
//    static class MovingAverage {
//        private Queue<Integer> datastruct.queue;
//        private int size;
//
//        /**
//         * Initialize your data structure here.
//         */
//        public MovingAverage(int size) {
//            datastruct.queue = new Queue<>();
//            this.size = size;
//        }
//
//        public double next(int val) {
//            if (datastruct.queue.size() == size) {
//                datastruct.queue.dequeue();
//            }
//            datastruct.queue.enqueue(val);
//
//            int sum = 0;
//            for (Integer integer : datastruct.queue) {
//                sum += integer;
//            }
//
//            return sum / datastruct.queue.size();
//        }
//    }
//
//}
