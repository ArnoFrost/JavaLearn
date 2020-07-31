package node;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 14:27
 * @Version 1.0
 * Code ==> 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
public class HasCycle {

    /**
     * 哈希表方法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode<Integer> head) {
        Set<ListNode<Integer>> nodeSeen = new HashSet<>();
        while (head != null) {
            if (nodeSeen.contains(head)) {
                return true;
            } else {
                nodeSeen.add(head);
            }
            head = head.getNext();
        }

        return false;
    }

    public static boolean has(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head.getNext();

        while (slow != fast) {
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return true;
    }

    /**
     * 快慢指针方式
     *
     * @param head
     * @return
     */
    public static boolean hasCycleSlowFast(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head.getNext();
        while (slow != fast) {
            //如果慢指针先到达终点则不存在环
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            //继续下次
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return true;
    }
}
