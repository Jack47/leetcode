package BinaryTree;

import TreeNode.TreeNode;

public class ConstructBinaryTreeByInOrderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        return buildTree(inorder, 0, postorder, 0, inorder.length);
    }

    TreeNode buildTree(int[] inorder,
                       int inorderStart,
                       int[] postorder,
                       int postorderStart,
                       int length) {
        assert length > 0 && length <= inorder.length;
        assert inorderStart >= 0 && inorderStart < inorder.length;
        assert postorderStart >= 0 && postorderStart < inorder.length;

        TreeNode root = new TreeNode(postorder[postorderStart + length - 1]);
        int rootIndex = find(inorder, inorderStart, inorderStart + length, root.val);
        assert rootIndex >= inorderStart && rootIndex < inorderStart + length;
        int leftLength = rootIndex - inorderStart;
        int rightLength = length - leftLength - 1;
        if (leftLength > 0) {
            root.left = buildTree(inorder, inorderStart, postorder, postorderStart, leftLength);
        }
        if (rightLength > 0) {
            root.right = buildTree(inorder, rootIndex+1, postorder, postorderStart+ leftLength, rightLength);
        }
        return root;
    }

    int find(int[] nums, int startIndex, int endIndex, int num) {
        while (startIndex < endIndex && nums[startIndex] != num) {
            startIndex++;
        }
        if (startIndex < endIndex) return startIndex;
        else return -1;
    }
}
