package queue;

import node.ListNode;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 19:40
 * @Version 1.0
 */
public class LinkQueue<T> {
    private ListNode front;
    private ListNode rear;
    private int size;

    public LinkQueue() {
        ListNode node = new ListNode();
        front = node;
        rear = node;
    }

    public void enqueue(int data) {
        ListNode node = new ListNode();
        rear.next = node;
        rear = node;
        size++;
    }

    public T dequeue() {
        if (front == rear) {
            return null;
        }

        ListNode node = front.next;
        T t = (T) node.val;
        front.next = node.next;
        if (node.next == null) {
            rear = front;
        }
        size--;
        return t;
    }

    public T getQueueTop() {
        return (T) front.next.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
