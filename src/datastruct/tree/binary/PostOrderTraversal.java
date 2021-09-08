package datastruct.tree.binary;

import java.util.*;

/**
 * @author ArnoFrost
 * @date 2020/5/18 18:19
 * @since 1.0
 */
public class PostOrderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Deque<TreeNode> treeStack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null || !treeStack.isEmpty()) {
            while (curr != null) {
                treeStack.push(curr);
                curr = curr.left;
            }
            curr = treeStack.peek();
            if (curr.right == null || curr.right.equals(pre)) {
                resultList.add(curr.getVal());
                treeStack.pop();
                pre = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }
        return resultList;
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

    public List<Integer> myPostOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> tmpStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                tmpStack.push(node);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        while (!tmpStack.isEmpty()) {
            resultList.add(tmpStack.pop().getVal());
        }
        return resultList;

    }

    public List<Integer> postOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.getVal());
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
