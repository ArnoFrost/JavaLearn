package datastruct.array;

import java.util.Iterator;

/**
 * @Author: ArnoFrost
 * @Date: 2019/9/16 16:12
 * @Version 1.0
 */
public class BagAsArray<Item> implements Iterable<Item> {
    private Item[] a;            // datastruct.stack entries
    private int n;               // size

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public BagAsArray(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        if (n == a.length) resize(2 * a.length);
        a[n++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++)
            temp[i] = a[i];
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private int i = n - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            return a[i--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

//    public static void main(String[] args) {
//        BagAsArray<String> bag = new BagAsArray<String>(4);
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            bag.add(item);
//        }
//
//        StdOut.println("size of bag = " + bag.size());
//        for (String s : bag) {
//            StdOut.println(s);
//        }
//    }

}
