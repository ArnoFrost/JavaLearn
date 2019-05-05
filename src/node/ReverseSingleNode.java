package node;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:29
 * @Version 1.0
 * Code ==> 206.
 */
public class ReverseSingleNode {
    /**
     * 单链表翻转
     */
    public static ListNode revertSingleLinknode(ListNode head) {
        if(head == null){
            return null;
        }
        //前指针节点
        ListNode prev = null;
        //当前指针节点
        ListNode now = head;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (now != null) {
            //临时节点，暂存当前节点的下一节点，用于后移
            ListNode next = now.next;
            //将当前节点指向它前面的节点
            now.next = prev;
            //前指针后移
            prev = now;
            //当前指针后移
            now = next;
            System.out.println("now =" + now.printList());
            System.out.println("prev =" + prev.printList());
        }

        return prev;
    }

    public static ListNode reverseLinkedNodeNew(ListNode head) {
        if (head == null || head.next == null) {
            System.out.println("listNode null = [" + head.printList() + "]");
            return head;
        } else {
            ListNode headListNode = reverseLinkedNodeNew(head.next);
            head.next.next = head;
            head.next = null;
            System.out.println("listNode = [" + head.printList() + "]");
            return headListNode;
        }
    }

    public ListNode reverse2(ListNode head, ListNode prev) {
        if (head.next == null) {
            head.next = prev;
            return head;
        } else {
            ListNode re = reverse2(head.next, head);
            head.next = prev;
            return re;
        }
    }

    public static ListNode reverse3(ListNode head) {
        if (head.next == null) {
            System.out.println("listNode null = [" + head + "]");
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode re = reverse3(next);
        next.next = head;
        System.out.println("listNode = [" + head + "]");
        return re;
    }

    public static ListNode reverseNew(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode e = null,f = null, cur = head;
        while ((e = cur.next) != null) {
            cur.next = f;
            f = cur;
            cur = e;
        }
        cur.next = f;
        return cur;
    }
}
