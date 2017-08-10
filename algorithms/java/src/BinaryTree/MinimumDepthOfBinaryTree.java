package BinaryTree;

public class MinimumDepthOfBinaryTree {
    int min;
    int cur;

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        cur++;
        if (root.left == null && root.right == null) {
            min = Math.min(min, cur);
        } else {
            dfs(root.left);
            dfs(root.right);
        }
        cur--;
    }

    public int minDepth(TreeNode root) {
        min = Integer.MAX_VALUE;
        cur = 0;
        if (root == null) return cur;
        dfs(root);
        return min;
    }
}
