package algo.swap;

/**
 * @author ArnoFrost
 * @date 2020/4/9 21:41
 * @since 1.0
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 现有一个链表 --head =[4,5,1,9]，它可以表示为:
 * <p>
 * 4->5->1->9
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], datastruct.node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], datastruct.node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 
 * <p>
 * 说明:
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteNode_237 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

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

        deleteNode(head);

        printNode(head);
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

    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("datastruct.node should be valid and can not be the tail datastruct.node");
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
