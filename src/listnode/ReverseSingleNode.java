package listnode;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:29
 * @Version 1.0
 */
public class ReverseSingleNode {
    /**
     * 单链表翻转
     */
    public static ListNode revertSingleLinknode(ListNode listNode) {
        ListNode prev = null;
        ListNode now = listNode;
        while (now != null) {
            ListNode next = now.next;
            now.next = prev;
            prev = now;
            now = next;
            System.out.println("now =" + now);
            System.out.println("prev =" + prev);
        }

        return prev;
    }

    public ListNode reverse2(ListNode listNode, ListNode prev) {
        if (listNode.next == null) {
            listNode.next = prev;
            return listNode;
        } else {
            ListNode re = reverse2(listNode.next, listNode);
            listNode.next = prev;
            return re;
        }
    }

    public static ListNode reverse3(ListNode listNode) {
        if (listNode.next == null) {
            System.out.println("listNode null = [" + listNode + "]");
            return listNode;
        }
        ListNode next = listNode.next;
        listNode.next = null;
        ListNode re = reverse3(next);
        next.next = listNode;
        System.out.println("listNode = [" + listNode + "]");
        return re;
    }

    public static ListNode reverseLinkedList(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            System.out.println("listNode null = [" + listNode + "]");
            return listNode;
        } else {
            ListNode headListNode = reverseLinkedList(listNode.next);
            listNode.next.next = listNode;
            listNode.next = null;
            System.out.println("listNode = [" + listNode + "]");
            return headListNode;
        }
    }
}
