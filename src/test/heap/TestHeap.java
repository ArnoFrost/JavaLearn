package test.heap;

import heap.MaxHeap;
import heap.MinHeap;

/**
 * @Author: ArnoFrost
 * @Date: 2020/3/31 20:04
 * @Version 1.0
 */
public class TestHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(100);
        MinHeap minHeap = new MinHeap(100);

//        for (int i = 0; i < 30; i++) {
//            heap.insert(TestUtils.getRandomNumber(1, 100));
//        }
        heap.insert(1);
        heap.insert(8);
        heap.insert(6);
        heap.insert(2);
        heap.insert(5);
//        heap.insert(4);
//        heap.insert(7);
//        heap.insert(3);
        heap.treePrint();

        while (!heap.isEmpty()) {
            System.out.print(heap.extractMax().toString() + ",");
        }
//        minHeap.insert(1);
//        minHeap.insert(8);
//        minHeap.insert(6);
//        minHeap.insert(2);
//        minHeap.insert(5);
//        minHeap.insert(4);
//        minHeap.insert(7);
//        minHeap.insert(3);

        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(5);

        minHeap.treePrint();

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin().toString() + ",");
        }
    }
}
