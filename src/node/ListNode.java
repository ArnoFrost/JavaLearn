package node;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:26
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
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
}
