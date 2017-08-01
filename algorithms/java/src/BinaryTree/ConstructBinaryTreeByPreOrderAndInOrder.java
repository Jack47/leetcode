package BinaryTree;

import TreeNode.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given preorder and inorder travseral of a binary tree, construct the tree.
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeByPreOrderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder,
                              int preorderStart,
                              int[] inorder,
                              int inorderStart,
                              int length) {
        assert length > 0;
        assert preorderStart >= 0 && preorderStart < preorder.length;
        assert inorderStart >= 0 && inorderStart < preorder.length;

        TreeNode rootNode = new TreeNode(preorder[preorderStart]);
        int rootIndex = find(inorder, inorderStart, inorderStart + length,
                rootNode.val);
        assert rootIndex >= inorderStart && rootIndex < inorderStart + length : "rootIndex:" +
                rootIndex;
        int leftLength = rootIndex - inorderStart;
        int rightLength = length - leftLength - 1;
        if (leftLength > 0) {
            rootNode.left = buildTree(preorder, preorderStart + 1, inorder, inorderStart,
                    leftLength);
        }
        if (rightLength > 0) {
            rootNode.right = buildTree(preorder, preorderStart + 1 + leftLength, inorder,
                    rootIndex + 1, rightLength);
        }
        return rootNode;
    }

    public int find(int[] nums, int startIndex, int endIndex, int num) {
        while (startIndex < endIndex && nums[startIndex] != num) {
            startIndex++;
        }
        if (startIndex < endIndex && nums[startIndex] == num) {
            return startIndex;
        } else return -1;
    }

}
