package node;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:26
 * @Version 1.0
 */
public class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T data) {
        this.setData(data);
    }

    public ListNode(T data, ListNode next) {
        this.setData(data);
        this.setNext(next);
    }

    public String printList() {
        if (getNext() == null) {
            return "node data = " + getData() + ",node next ==> null";
        }
        return "node data = " + getData() + ",node next ==> " + getNext().printList();
    }

    @Override
    public String toString() {
        if (getNext() == null) {
            return "node data = " + getData() + ",node next = null";
        }
        return "data = " + getData() + ", next = " + getNext().getData();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
