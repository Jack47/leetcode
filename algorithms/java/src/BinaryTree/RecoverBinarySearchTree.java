package BinaryTree;

public class RecoverBinarySearchTree {
    TreeNode first, second, pre;

    void inOrderVisit(TreeNode root) {
        if(root == null) return;
        inOrderVisit(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
                // in case two adjacent cells are swapped
                second = root;
            } else { // non-adjacent cells are swapped
                second = root;
            }
        }
        pre = root;
        inOrderVisit(root.right);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inOrderVisit(root);
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
}
