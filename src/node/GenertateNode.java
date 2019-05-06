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
    public static ListNode<Integer> getNodeByNumber(boolean withHead, int... numbers) {
        if (numbers == null) {
            return null;
        }

        ListNode<Integer> listNode = new ListNode<>();
        ListNode<Integer> temp = listNode;

        for (int number : numbers) {
            temp.setNext(new ListNode<>(number));
            temp = temp.getNext();
        }
        if (withHead) {
            System.out.println("node start = [" + listNode.printList() + "]");
            return listNode;
        }
        System.out.println("node start = [" + listNode.getNext().printList() + "]");
        return listNode.getNext();

    }

    public static ListNode<Integer> getSimpleNode(boolean withHead) {
        ListNode<Integer> linkListNode1 = new ListNode<>(1);
        ListNode<Integer> linkListNode2 = new ListNode<>(2);
        ListNode<Integer> linkListNode3 = new ListNode<>(3);
        ListNode<Integer> linkListNode4 = new ListNode<>(4);
        ListNode<Integer> linkListNode5 = new ListNode<>(5);
        ListNode<Integer> linkListNode6 = new ListNode<>(6);

        if (withHead) {
            ListNode<Integer> head = new ListNode<>();
            linkListNode1.setNext(linkListNode2);
            linkListNode2.setNext(linkListNode3);
            linkListNode3.setNext(linkListNode4);
            linkListNode4.setNext(linkListNode5);
            linkListNode5.setNext(linkListNode6);
            System.out.println("node start = [" + head.printList() + "]");
            return head;
        } else {
            linkListNode1.setNext(linkListNode2);
            linkListNode2.setNext(linkListNode3);
            linkListNode3.setNext(linkListNode4);
            linkListNode4.setNext(linkListNode5);
            linkListNode5.setNext(linkListNode6);
        }


        System.out.println("node start = [" + linkListNode1.printList() + "]");
        return linkListNode1;

    }

    public static ListNode<Integer> getSimpleCycleNode(boolean withHead) {
        ListNode<Integer> linkListNode1 = new ListNode<>(1);
        ListNode<Integer> linkListNode2 = new ListNode<>(2);
        ListNode<Integer> linkListNode3 = new ListNode<>(3);
        ListNode<Integer> linkListNode4 = new ListNode<>(4);
        ListNode<Integer> linkListNode5 = new ListNode<>(5);

        if (withHead) {
            ListNode<Integer> head = new ListNode<>();
            head.setNext(linkListNode1);
            linkListNode1.setNext(linkListNode2);
            linkListNode2.setNext(linkListNode3);
            linkListNode3.setNext(linkListNode4);
            linkListNode4.setNext(linkListNode5);
            linkListNode5.setNext(linkListNode2);
            System.out.println("node start = [" + head.toString() + "]");
            return head;
        } else {
            linkListNode1.setNext(linkListNode2);
            linkListNode2.setNext(linkListNode3);
            linkListNode3.setNext(linkListNode4);
            linkListNode4.setNext(linkListNode5);
            linkListNode5.setNext(linkListNode2);
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
    public static ListNode<Integer> getRadomNode(int length) {
        ListNode<Integer> listNode = new ListNode<>(0);
        if (length >= 0) {
            ListNode cur = listNode;

            for (int i = 0; i < length; i++) {
                cur.setNext(new ListNode<>(getRadomNumber(1, 10)));
                cur = cur.getNext();
            }
        }
        System.out.println("getRadomNode = " + listNode.getNext().printList());
        return listNode.getNext();
    }

    public static ListNode<Integer> getRadomOrderNode(int length) {
        ListNode<Integer> listNode = new ListNode<>(0);
        if (length >= 0) {
            ListNode<Integer> cur = listNode;

            for (int i = 0; i < length; i++) {
                int num = getRadomNumber(1, 10);
                while ((Integer) cur.getData() >= num) {
                    num = getRadomNumber(1, 10);
                }
                cur.setNext(new ListNode<>(num));
                cur = cur.getNext();
            }
        }
        System.out.println("getRadomOrderNode = " + listNode.getNext().printList());
        return listNode.getNext();
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
