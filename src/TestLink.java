import node.GenertateNode;
import node.ListNode;
import node.MergeTwoLists;

/**
 * @Author: ArnoFrost
 * @Date: 2019-04-30 10:33
 * @Version 1.0
 */
public class TestLink {
    public static void main(String[] args) {
        ListNode listNode1 = GenertateNode.getRadomOrderNode(3);
        ListNode listNode2 = GenertateNode.getRadomOrderNode(3);
//        ListNode listNode = MergeTwoLists.mergeTwoLists(listNode1, listNode2);
        ListNode listNode = MergeTwoLists.mergeTwoListNew(listNode1, listNode2);

//        ListNode listNode = ReverseSingleNode.revertSingleLinknode(GenertateNode.getRadomNode(2));
//        node listNode = reverse3(getSimpleNode());
//        node listNode = reverseLinkedNodeNew(getSimpleNode());
//        node listNode = removeNthFromEnd(getSimpleNode(), 2);

        System.out.println("listNode final = [" + listNode + "]");
    }
}
