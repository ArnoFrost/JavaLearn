package listnode;

import java.util.Random;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 10:28
 * @Version 1.0
 */
public class GenertateNode {
    public static ListNode getSimpleNode() {
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
        System.out.println("getRadomNode = " + listNode.next);
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
        System.out.println("getRadomOrderNode = " + listNode.next);
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
