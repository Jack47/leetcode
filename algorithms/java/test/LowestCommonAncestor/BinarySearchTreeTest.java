package LowestCommonAncestor;

import static org.junit.Assert.assertEquals;

import TreeNode.TreeNode;
import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void test() {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode p = new TreeNode(0);
        TreeNode q = new TreeNode(3);

        TreeNode result = binarySearchTree.lowestCommonAncestor(null, p, q);
        assertEquals(null, result);

        TreeNode root = new TreeNode(6);
        result = binarySearchTree.lowestCommonAncestor(root, p, q);
        assertEquals(null, result);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        result = binarySearchTree.lowestCommonAncestor(root, p, q);
        assertEquals(2, result.val);

        result = binarySearchTree.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(2));
        assertEquals(2, result.val);

        result = binarySearchTree.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(9));
        assertEquals(6, result.val);
    }
}
