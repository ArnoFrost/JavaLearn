/**
 * @Author: ArnoFrost
 * @Date: 2019-04-30 10:33
 * @Version 1.0
 */
public class TestLink {
    public static void main(String[] args) {
//        ListNode listNode = revertSingleLinknode(readyNode());
//        ListNode listNode = reverse3(readyNode());
//        ListNode listNode = reverseLinkedList(readyNode());
//        ListNode listNode = removeNthFromEnd(readyNode(), 2);
//        System.out.println("listNode final = [" + listNode + "]");


    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode val = " + val + ",node next =" + next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }

            if (l1 == null) {
                cur.next = l2;
            } else {
                cur.next = l1;
            }
        }
        return dummyHead.next;

    }

    private static ListNode readyNode() {
        ListNode linkListNode1 = new ListNode(1);
        ListNode linkListNode2 = new ListNode(2);
        ListNode linkListNode3 = new ListNode(3);
        ListNode linkListNode4 = new ListNode(4);
        ListNode linkListNode5 = new ListNode(5);
        ListNode linkListNode6 = new ListNode(6);

        linkListNode1.next = linkListNode2;
        linkListNode2.next = linkListNode3;
        linkListNode3.next = linkListNode4;
        linkListNode4.next = linkListNode5;
        linkListNode5.next = linkListNode6;

        System.out.println("node start = [" + linkListNode1 + "]");
        return linkListNode1;

    }

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


    /**
     * 单链表翻转
     */
    private static ListNode revertSingleLinknode(ListNode listNode) {
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

    private ListNode reverse2(ListNode listNode, ListNode prev) {
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
