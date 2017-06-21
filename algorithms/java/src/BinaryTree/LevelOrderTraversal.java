package BinaryTree;

import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class LevelOrderTraversal {
    List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int nextLevelNodeCount = 0;
        int curLevelVisitedNodeCount = 0;

        // NOTE: remember this, haha
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int curLevelNodeCount = 1;

        List<Integer> curLevelNodes = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            curLevelVisitedNodeCount++;
            curLevelNodes.add(cur.val);
            if (cur.left != null) {
                q.add(cur.left);
                nextLevelNodeCount++;
            }
            if (cur.right != null) {
                q.add(cur.right);
                nextLevelNodeCount++;
            }
            if (curLevelVisitedNodeCount == curLevelNodeCount) {
                ret.add(curLevelNodes);
                curLevelNodes = new ArrayList<Integer>();
                curLevelVisitedNodeCount = 0;
                curLevelNodeCount = nextLevelNodeCount;
                nextLevelNodeCount = 0;
            }
        }

        return ret;
    }
}
