package LowestCommonAncestor;

import static org.junit.Assert.assertEquals;

import TreeNode.TreeNode;
import org.junit.Test;

public class BinaryTreeTest {
    @Test
    public void testBinarySearchTree() {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode p = null;
        TreeNode q = null;

        TreeNode result = binaryTree.lowestCommonAncestor(null, p, q);
        assertEquals(null, result);

        TreeNode root = new TreeNode(6);
        p = q = root;
        result = binaryTree.lowestCommonAncestor(root, p, q);
        assertEquals(root, result);

        root.left = new TreeNode(2);
        p = root.left;
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        q = root.left.right.right;
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        result = binaryTree.lowestCommonAncestor(root, p, q);
        assertEquals(p, result);

        result = binaryTree.lowestCommonAncestor(root, p, root.right.right);
        assertEquals(root, result);
    }

    @Test
    public void testBinaryTree() {

        BinaryTree binaryTree = new BinaryTree();

        TreeNode result = binaryTree.lowestCommonAncestor(null, new TreeNode(1), new TreeNode(2));
        assertEquals(null, result);

        TreeNode root = new TreeNode(3);
        result = binaryTree.lowestCommonAncestor(root, root, root);
        assertEquals(root, result);

        root.left = new TreeNode(5);
        TreeNode p1 = root.left;
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        TreeNode q2 = root.left.left;
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        TreeNode p2 = root.left.right.left;
        root.left.right.right = new TreeNode(4);
        TreeNode q1 = root.left.right.right ;
        root.right.left = new TreeNode(0);
        TreeNode p3 = root.right.left;
        root.right.right = new TreeNode(8);

        result = binaryTree.lowestCommonAncestor(root, p1, q1);
        assertEquals(p1, result);

        result = binaryTree.lowestCommonAncestor(root, p2, q2);
        assertEquals(p1, result);

        result = binaryTree.lowestCommonAncestor(root, q1, p3);
        assertEquals(root, result);
    }

    @Test
    public void testBinaryTree2() {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(37);
        root.left = new TreeNode(-34);
        root.left.right = new TreeNode(-100);
        TreeNode q = root.left.right;
        root.right = new TreeNode(-48);
        TreeNode parent1 = root.right;
        root.right.left = new TreeNode(-100);
        TreeNode p = root.right.left;
        root.right.right = new TreeNode(48);
        root.right.right.left = new TreeNode(-54);
        root.right.right.left.left = new TreeNode(-71);
        TreeNode q2 = root.right.right.left.left;
        root.right.right.left.right = new TreeNode(-22);
        root.right.right.left.right.right = new TreeNode(8);

        TreeNode result = binaryTree.lowestCommonAncestor(root, p, q);
        assertEquals(root, result);

        result = binaryTree.lowestCommonAncestor(root, q, q2);
        assertEquals(root, result);

        result = binaryTree.lowestCommonAncestor(root, p, q2);
        assertEquals(parent1, result);
    }
}
