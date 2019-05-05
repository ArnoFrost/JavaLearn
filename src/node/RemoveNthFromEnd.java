package node;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:28
 * @Version 1.0
 * Code ==> 19. 删除链表倒数第N个节点
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        //dummy.next -> head
        dummy.next = head;
        int length = 0;
        //first -> head
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        // first - > dummy - > head;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
            System.out.println("first = " + first);
        }

        first.next = first.next.next;

        return dummy.next;
    }
}
