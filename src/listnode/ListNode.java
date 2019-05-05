package listnode;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:26
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "listnode val = " + val + ",node next =" + next;
    }
}
