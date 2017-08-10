package BinaryTree;

public class InvertBinaryTree {
    void invert(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invert(root.left);
        invert(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}
