package stack;


import java.util.Iterator;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 17:01
 * @Version 1.0
 * 自定义链表栈结构
 */
public class LinkStack<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int n;

    public LinkStack() {
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;

        return item;
    }

    public Item peek() {
        return first.item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        int i = n;
        Node t = first;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            Item item = t.item;
            t = t.next;
            i--;
            return item;
        }

    }
}
