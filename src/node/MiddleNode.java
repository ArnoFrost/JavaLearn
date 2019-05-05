package node;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 11:21
 * @Version 1.0
 * Code ==> 876. 求链表中间节点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode[] temp = new ListNode[100];
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            temp[index] = cur;
            cur = cur.next;
            index++;
        }

        if (index % 2 == 0) {
            return temp[index / 2 + 1];
        } else {
            return temp[index / 2];
        }
    }

    /**
     * 快慢指针(快指针两倍速,当快指针达到末尾,慢指针为中间)
     * @param head
     * @return
     */
    public ListNode middleNodeSlowFast(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
