package node;

import java.util.Random;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:28
 * @Version 1.0
 */
public class GenertateNode {
    /**
     * 根据输入数字得到指定的单链表
     *
     * @param withHead
     * @param numbers
     * @return
     */
    public static ListNode getNodeByNumber(boolean withHead, int... numbers) {
        if (numbers == null) {
            return null;
        }

        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;

        for (int number : numbers) {
            temp.next = new ListNode(number);
            temp = temp.next;
        }
        if (withHead) {
            System.out.println("node start = [" + listNode.printList() + "]");
            return listNode;
        }
        System.out.println("node start = [" + listNode.next.printList() + "]");
        return listNode.next;

    }

    public static ListNode getSimpleNode(boolean withHead) {
        ListNode linkListNode1 = new ListNode(1);
        ListNode linkListNode2 = new ListNode(2);
        ListNode linkListNode3 = new ListNode(3);
        ListNode linkListNode4 = new ListNode(4);
        ListNode linkListNode5 = new ListNode(5);
        ListNode linkListNode6 = new ListNode(6);

        if (withHead) {
            ListNode head = new ListNode(0);
            head.next = linkListNode1;
            linkListNode1.next = linkListNode2;
            linkListNode2.next = linkListNode3;
            linkListNode3.next = linkListNode4;
            linkListNode4.next = linkListNode5;
            linkListNode5.next = linkListNode6;
            System.out.println("node start = [" + head.printList() + "]");
            return head;
        } else {
            linkListNode1.next = linkListNode2;
            linkListNode2.next = linkListNode3;
            linkListNode3.next = linkListNode4;
            linkListNode4.next = linkListNode5;
            linkListNode5.next = linkListNode6;
        }


        System.out.println("node start = [" + linkListNode1.printList() + "]");
        return linkListNode1;

    }

    public static ListNode getSimpleCycleNode(boolean withHead) {
        ListNode linkListNode1 = new ListNode(1);
        ListNode linkListNode2 = new ListNode(2);
        ListNode linkListNode3 = new ListNode(3);
        ListNode linkListNode4 = new ListNode(4);
        ListNode linkListNode5 = new ListNode(5);

        if (withHead) {
            ListNode head = new ListNode(0);
            head.next = linkListNode1;
            linkListNode1.next = linkListNode2;
            linkListNode2.next = linkListNode3;
            linkListNode3.next = linkListNode4;
            linkListNode4.next = linkListNode5;
            linkListNode5.next = linkListNode2;
            System.out.println("node start = [" + head.toString() + "]");
            return head;
        } else {
            linkListNode1.next = linkListNode2;
            linkListNode2.next = linkListNode3;
            linkListNode3.next = linkListNode4;
            linkListNode4.next = linkListNode5;
            linkListNode5.next = linkListNode2;
        }


        System.out.println("node start = [" + linkListNode1.toString() + "]");
        return linkListNode1;
    }

    /**
     * 得到一个指定长度的随机链表
     *
     * @param length
     * @return
     */
    public static ListNode getRadomNode(int length) {
        ListNode listNode = new ListNode(0);
        if (length >= 0) {
            ListNode cur = listNode;

            for (int i = 0; i < length; i++) {
                cur.next = new ListNode(getRadomNumber(1, 10));
                cur = cur.next;
            }
        }
        System.out.println("getRadomNode = " + listNode.next.printList());
        return listNode.next;
    }

    public static ListNode getRadomOrderNode(int length) {
        ListNode listNode = new ListNode(0);
        if (length >= 0) {
            ListNode cur = listNode;

            for (int i = 0; i < length; i++) {
                int num = getRadomNumber(1, 10);
                while (cur.val >= num) {
                    num = getRadomNumber(1, 10);
                }
                cur.next = new ListNode(num);
                cur = cur.next;
            }
        }
        System.out.println("getRadomOrderNode = " + listNode.next.printList());
        return listNode.next;
    }

    /**
     * 返回一个指定区间的随机数
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRadomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}
