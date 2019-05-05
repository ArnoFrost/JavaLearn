package test.node;

import junit.framework.TestCase;
import node.GenertateNode;
import node.ListNode;
import node.MiddleNode;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 11:47
 * @Version 1.0
 */
public class TestMiddleNode extends TestCase {
    public void testMiddle() {
//        ListNode node = GenertateNode.getSimpleNode(true);
        ListNode node = GenertateNode.getNodeByNumber(false, 0, 2, 4, 5);
        node = MiddleNode.middleNode(node);

//        assert (node.next.val == 4);
        System.out.println("middleNode : " + node);
    }
}
