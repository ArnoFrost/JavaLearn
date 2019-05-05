package node;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:26
 * @Version 1.0
 */
public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String printList() {
        if (next == null) {
            return "node val = " + val + ",node next ==> null";
        }
        return "node val = " + val + ",node next ==> " + next.printList();
    }

    @Override
    public String toString() {
        if (next == null) {
            return "node val = " + val + ",node next = null";
        }
        return "val = " + val + ", next = " + next.val;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
