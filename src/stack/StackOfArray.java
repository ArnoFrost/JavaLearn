package stack;

import java.util.Iterator;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 16:25
 * @Version 1.0
 * 自定义数组实现栈结构
 */
public class StackOfArray<Item> implements Iterable<Item> {
    Item[] a = (Item[]) new Object[10];

    int n = 0;

    public StackOfArray() {

    }

    /**
     * 入栈
     *
     * @param item
     */
    public boolean push(Item item) {
        try {
            if (n == a.length) {
                resize(2 * a.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        a[n++] = item;
        return true;
    }

    public Item pop() {
        Item item = a[--n];
        a[n] = null;
        //优化空间
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }

        return item;

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    /**
     * 自动扩容
     *
     * @param length
     */
    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Item peek() {
        return a[n - 1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
