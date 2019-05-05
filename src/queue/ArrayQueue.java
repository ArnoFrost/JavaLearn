package queue;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 19:32
 * @Version 1.0
 */
public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        //队列满了
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = 0; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue() {
        //空队列
        if (head == tail) {
            return null;
        }

        String ret = items[head];
        head++;
        return ret;
    }

}
