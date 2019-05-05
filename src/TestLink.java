import listnode.GenertateNode;
import listnode.ListNode;
import listnode.MergeTwoLists;
import listnode.ReverseSingleNode;

/**
 * @Author: ArnoFrost
 * @Date: 2019-04-30 10:33
 * @Version 1.0
 */
public class TestLink {
    public static void main(String[] args) {
        ListNode listNode1 = GenertateNode.getRadomNode(3);
        ListNode listNode2 = GenertateNode.getRadomNode(3);
        ListNode listNode = MergeTwoLists.mergeTwoLists(listNode1, listNode2);

//        ListNode listNode = ReverseSingleNode.revertSingleLinknode(GenertateNode.getRadomNode(2));
//        listnode listNode = reverse3(getSimpleNode());
//        listnode listNode = reverseLinkedList(getSimpleNode());
//        listnode listNode = removeNthFromEnd(getSimpleNode(), 2);

        System.out.println("listNode final = [" + listNode + "]");
    }
}
