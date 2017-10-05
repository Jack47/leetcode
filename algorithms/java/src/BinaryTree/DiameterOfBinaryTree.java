package BinaryTree;

public class DiameterOfBinaryTree {
    int max;

    // return the longest path length upcoming to the upper layer
    int postOrderVisit(TreeNode root) {
        if (root == null) return 0;
        int left = postOrderVisit(root.left);
        int right = postOrderVisit(root.right);
        // join left and right
        max = Math.max(max, left + right + 1);
        // upper layer want to join the bigger length
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        if (root == null) return 0;
        postOrderVisit(root);
        return max - 1;
    }
}
