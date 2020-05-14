package tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/22 16:10
 * @Version 1.0
 */
public class PrintTree {
    private static final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        LinkedList<TreeNode> treeNodes = createBinTree();
        //非递归前序遍历
        System.out.println(preOder(treeNodes.get(0)));
        ;
    }

    /**
     * 非递归前序遍历
     *
     * @param node
     */
    private static ArrayList<Integer> preOder(TreeNode node) {
        ArrayList<Integer> valueList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (node != null) {
            TreeNode n = node;
            //当有元素时持续迭代
            while (n != null || !stack.isEmpty()) {
                if (n != null) {
                    valueList.add(n.getVal());
                    stack.push(n);
                    n = n.left;
                } else {
                    n = stack.pop();
                    n = n.right;
                }
            }
        }

        return valueList;
    }

    // 建树
    public static LinkedList<TreeNode> createBinTree() {
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        for (int i = 0; i < array.length; i++)
            nodeList.add(new TreeNode(array[i]));
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        int lastparentIndex = array.length / 2 - 1;
        nodeList.get(lastparentIndex).left = nodeList
                .get(lastparentIndex * 2 + 1);
        if (array.length % 2 == 1)
            nodeList.get(lastparentIndex).right = nodeList
                    .get(lastparentIndex * 2 + 2);

        return nodeList;

    }
}
