package test.node;

import junit.framework.TestCase;
import node.ListNode;
import node.MiddleNode;
import utils.NodeUtils;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 11:47
 * @Version 1.0
 */
public class TestMiddleNode extends TestCase {
    public void testMiddle() {
        ListNode node = NodeUtils.getNodeByNumber(false, 0, 2, 4, 5);
        node = MiddleNode.middleNode(node);
        if ((Integer) node.getData() == 4) {
            System.out.println("node data == 4");
        }

//        assert (node.next.data == 4);
        System.out.println("middleNode : " + node);
    }
}
