package datastruct.tree.binary;

import java.util.*;

/**
 * @author ArnoFrost
 * @date 2020/4/22 16:10
 * @since 1.0
 */
public class PrintTree {
    private static final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        LinkedList<TreeNode> treeNodes = createBinTree();
        //非递归前序遍历
        System.out.println(preOder(treeNodes.get(0)));
        //非递归后序遍历
        System.out.println(postorderTraversal2(treeNodes.get(0)));
        System.out.println(postOrder(treeNodes.get(0)));
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

    public static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> outStack = new Stack<>();

        preStack.push(root);
        while (!preStack.isEmpty()) {
            TreeNode node = preStack.pop();
            outStack.push(node);

            if (node.left != null) {
                preStack.push(node.left);
            }
            if (node.right != null) {
                preStack.push(node.right);
            }
        }

        List<Integer> outList = new ArrayList<>();
        while (!outStack.isEmpty()) {
            outList.add(outStack.pop().getVal());
        }

        return outList;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ret.add(node.getVal());
                stack.push(node.left);
                stack.push(node.right);
            }
        }

        Collections.reverse(ret);
        return ret;
    }

}
