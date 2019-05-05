package node;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:28
 * @Version 1.0
 * Code ==> 19. 删除链表倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 */
public class RemoveNthFromEnd {
    public static ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        ListNode<Integer> dummy = new ListNode<>();
        //dummy.next -> head
        dummy.next = head;
        int length = 0;
        //first -> head
        ListNode<Integer> first = head;
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
            System.out.println("first = " + first.printList());
        }

        first.next = first.next.next;

        return dummy.next;
    }
}
