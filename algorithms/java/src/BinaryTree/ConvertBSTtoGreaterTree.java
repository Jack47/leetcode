package BinaryTree;

public class ConvertBSTtoGreaterTree {
    int sum;
    void convert(TreeNode root) {
        if(root == null) return;
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convert(root);
        return root;
    }
}
