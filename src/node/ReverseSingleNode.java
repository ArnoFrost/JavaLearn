package node;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:29
 * @Version 1.0
 * Code ==> 206.
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseSingleNode {


    /**
     * 单链表翻转
     */
    public static ListNode<Integer> revertSingleLinknode(ListNode<Integer> head) {
        if (head == null) {
            return null;
        }
        //前指针节点
        ListNode<Integer> prev = null;
        //当前指针节点
        ListNode<Integer> now = head;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (now != null) {
            //临时节点，暂存当前节点的下一节点，用于后移
            ListNode<Integer> next = now.getNext();
            //将当前节点指向它前面的节点
            now.setNext(prev);
            //前指针后移
            prev = now;
            //当前指针后移
            now = next;
            System.out.println("now =" + now.printList());
            System.out.println("prev =" + prev.printList());
        }

        return prev;
    }

    public static ListNode<Integer> reverseLinkedNodeNew(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            System.out.println("listNode null = [" + head.printList() + "]");
            return null;
        } else {
            ListNode<Integer> headListNode = reverseLinkedNodeNew(head.getNext());
            head.getNext().setNext(head);
            head.setNext(null);
            System.out.println("listNode = [" + head.printList() + "]");
            return headListNode;
        }
    }

    public ListNode<Integer> reverse2(ListNode<Integer> head, ListNode<Integer> prev) {
        if (head.getNext() == null) {
            head.setNext(prev);
            return head;
        } else {
            ListNode re = reverse2(head.getNext(), head);
            head.setNext(prev);
            return re;
        }
    }

    public static ListNode<Integer> reverse3(ListNode<Integer> head) {
        if (head.getNext() == null) {
            System.out.println("listNode null = [" + head + "]");
            return head;
        }
        ListNode<Integer> next = head.getNext();
        head.setNext(null);
        ListNode<Integer> re = reverse3(next);
        next.setNext(head);
        System.out.println("listNode = [" + head + "]");
        return re;
    }

    public static ListNode<Integer> reverseNew(ListNode<Integer> head) {
        if (head == null) {
            return null;
        }
        ListNode<Integer> e = null, f = null, cur = head;
        while ((e = cur.getNext()) != null) {
            cur.setNext(f);
            f = cur;
            cur = e;
        }
        cur.setNext(f);
        return cur;
    }
}
