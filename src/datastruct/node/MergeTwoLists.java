package datastruct.node;

/**
 * @author ArnoFrost
 * @date 2019-05-05 10:27
 * @since 1.0
 * Code ==> 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode<>();
        ListNode<Integer> cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.getData() < l2.getData()) {
                cur.setNext(l1);
                cur = cur.getNext();
                l1 = l1.getNext();
            } else {
                cur.setNext(l2);
                cur = cur.getNext();
                l2 = l2.getNext();
            }
        }
        if (l1 == null) {
            cur.setNext(l2);
        } else {
            cur.setNext(l1);
        }
        return dummyHead.getNext();
    }

    public static ListNode<Integer> mergeTwoListNew(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (null == l1 && null == l2) {
            return null;
        } else if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        } else {
            final ListNode mockHeadNode = new ListNode(0);
            ListNode currNode = mockHeadNode;
            while (null != l1 || null != l2) {
                if (null == l1) {
                    //l1遍历完毕
                    currNode.setNext(l2);
                    break;
                }
                if (null == l2) {
                    //l2遍历完毕
                    currNode.setNext(l1);
                    break;
                }
                if (l1.getData() <= l2.getData()) {
                    currNode.setNext(l1);
                    l1 = l1.getNext();
                } else {
                    currNode.setNext(l2);
                    l2 = l2.getNext();
                }
                currNode = currNode.getNext();
            }
            return mockHeadNode.getNext();
        }
    }
}
