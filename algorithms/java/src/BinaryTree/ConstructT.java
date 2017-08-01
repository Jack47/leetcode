package BinaryTree;

public class ConstructT {
    TreeNode buildTreeInner(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if(e1 < s1) return null;
        TreeNode root = new TreeNode(preorder[s1]);
        int i = s2;
        while(inorder[i] != preorder[s1]) {
            i++;
        }
        int len = i-s2;
        root.left = buildTreeInner(preorder, s1+1, s1+len, inorder, s2, i-1);
        root.right = buildTreeInner(preorder, s1+len+1, e1, inorder, i+1, e2);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeInner(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
}
