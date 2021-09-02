package algo.swap;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/9 22:01
 * @Version 1.0
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList_24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);

        ListNode temp = head;
        int i = 1;
        int repeat = 10;
        while (i <= repeat) {
            temp.next = new ListNode(i++);
            temp = temp.next;
        }
        printNode(head);
        System.out.println();
//        printNode(reverseList(head));

        printNode(reverseList2(head));
    }

    /**
     * 题解信息
     * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/dong-hua-yan-shi-duo-chong-jie-fa-206-fan-zhuan-li/
     */

    public static ListNode myReverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;

            cur = next;
        }
        return pre;
    }

    /**
     * 迭代解法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归解法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList2(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void printNode(ListNode node) {
        if (node == null) {
            return;
        }
        do {
            System.out.print(node.val + ",");
            node = node.next;
            if (node != null && node.next == null) {
                System.out.print(node.val + ",");
            }
        }
        while (node.next != null);
    }
}
