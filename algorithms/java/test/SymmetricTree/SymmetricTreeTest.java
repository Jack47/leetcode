package SymmetricTree;

import static org.junit.Assert.assertEquals;

import TreeNode.TreeNode;
import org.junit.Test;

public class SymmetricTreeTest {
    @Test
    public void testIsArraySymmetric() {
        SymmetricTreeIterativeSolution symmetricTree = new SymmetricTreeIterativeSolution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        boolean result = symmetricTree.isArraySymmetic(new TreeNode[] {root1.left, root1, root1.right});
        assertEquals(false, result);

        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        result = symmetricTree.isArraySymmetic(new TreeNode[] {root1.left, root1, root1.right});
        assertEquals(true, result);

        result = symmetricTree.isArraySymmetic(new TreeNode[] {root1.left});
        assertEquals(true, result);
    }

    @Test
    public void testIsSymmetric() {
        SymmetricTreeIterativeSolution symmetricTree = new SymmetricTreeIterativeSolution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        boolean result = symmetricTree.isSymmetric(root1);
        assertEquals(false, result);

        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right.right = new TreeNode(3);

        result = symmetricTree.isSymmetric(root1);
        assertEquals(true, result);

        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right.right = new TreeNode(4);
        result = symmetricTree.isSymmetric(root1);
        assertEquals(false, result);
    }
}
