package datastruct.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/18 17:18
 * @Version 1.0
 */
public class PreOrderTraversal {
    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        return getPreOder(new ArrayList<Integer>(), root);
    }

    private static List<Integer> getPreOder(List<Integer> integers, TreeNode root) {
        if (root == null) {
            return integers;
        }
        integers.add(root.getVal());
        getPreOder(integers, root.getLeft());
        getPreOder(integers, root.getRight());
        return integers;
    }

    /**
     * 非递归方式
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                list.add(cur.getVal());
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }
}
