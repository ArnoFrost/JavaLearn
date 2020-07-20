package tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/18 19:13
 * @Version 1.0
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        int levelNum = 0;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            levelNum = treeNodeQueue.size();
            List<Integer> levelList = new ArrayList<>();
            while (levelNum > 0) {
                TreeNode temp = treeNodeQueue.poll();
                if (temp != null) {
                    levelList.add(temp.getVal());
                    treeNodeQueue.add(temp.left);
                    treeNodeQueue.add(temp.right);
                }
                levelNum--;
            }
            if (levelList.size() > 0) {
                resultList.add(levelList);
            }
        }
        return resultList;
    }
}
