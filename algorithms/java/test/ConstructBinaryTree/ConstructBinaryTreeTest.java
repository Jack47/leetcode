package ConstructBinaryTree;

import static org.junit.Assert.assertEquals;

import BinaryTree.ConstructBinaryTreeByInOrderAndPostOrder;
import BinaryTree.ConstructBinaryTreeByPreOrderAndInOrder;
import TreeNode.TreeNode;
import org.junit.Test;

public class ConstructBinaryTreeTest {
    @Test
    public void testFind() {
        int[] preorder = new int[]{1, 2, 6, 3, 8, 4, 5, 7, 6};
        ConstructBinaryTreeByPreOrderAndInOrder constructBinaryTree = new
                ConstructBinaryTreeByPreOrderAndInOrder();
        int result = constructBinaryTree.find(preorder, 0, preorder.length, 8);
        assertEquals(4, result);
        result = constructBinaryTree.find(preorder, 3, preorder.length, 10);
        assertEquals(-1, result);
    }

    @Test
    public void testPreOrderAndInorder() {
        ConstructBinaryTreeByPreOrderAndInOrder constructBinaryTree = new
                ConstructBinaryTreeByPreOrderAndInOrder();
        int[] preorder = new int[]{1, 2, 6, 3, 8, 4, 5, 7, 9};
        int[] inorder = new int[]{6, 2, 8, 3, 1, 5, 7, 4, 9};

        TreeNode root = constructBinaryTree.buildTree(preorder, inorder);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(6, root.left.left.val);
        assertEquals(3, root.left.right.val);
        assertEquals(8, root.left.right.left.val);
        assertEquals(4, root.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(7, root.right.left.right.val);
        assertEquals(9, root.right.right.val);
    }

    @Test
    public void testInorderAndPostOrder() {
        ConstructBinaryTreeByInOrderAndPostOrder constructBinaryTree = new
                ConstructBinaryTreeByInOrderAndPostOrder();
        int[] postorder = new int[]{6, 8, 3, 2, 7, 5, 9, 4, 1};
        int[] inorder = new int[]{6, 2, 8, 3, 1, 5, 7, 4, 9};

        TreeNode root = constructBinaryTree.buildTree(inorder, postorder);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(6, root.left.left.val);
        assertEquals(3, root.left.right.val);
        assertEquals(8, root.left.right.left.val);
        assertEquals(4, root.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(7, root.right.left.right.val);
        assertEquals(9, root.right.right.val);
    }
}
