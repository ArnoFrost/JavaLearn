package test.node;

import junit.framework.TestCase;
import node.GenertateNode;
import node.HasCycle;
import node.ListNode;

/**
 * @Author: ArnoFrost
 * @Date: 2019-05-05 14:36
 * @Version 1.0
 */
public class TestHasCycle extends TestCase {
    public void testHasCycle() {
        ListNode node = GenertateNode.getNodeByNumber(false, 1, 4, -5, 7, 8);
        boolean flag = HasCycle.hasCycleSlowFast(node);
        assert (!flag);

        ListNode node2 = GenertateNode.getSimpleCycleNode(false);
        boolean flag2 = HasCycle.hasCycleSlowFast(node2);
        assert (flag2);
    }
}
