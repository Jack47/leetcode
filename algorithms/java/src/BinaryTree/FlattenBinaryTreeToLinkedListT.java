package BinaryTree;

public class FlattenBinaryTreeToLinkedListT {
    TreeNode pre;
    void flattenInner(TreeNode root) {
        if(root == null) return;
        pre.right = root;
        pre = root;
        TreeNode right = root.right;
        flattenInner(root.left);
        root.left = null;
        flattenInner(right);
    }
    public void flatten(TreeNode root) {
        pre = new TreeNode(0);
        flattenInner(root);
    }
}
