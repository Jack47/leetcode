package BinaryTree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;
import org.junit.Test;

public class BinaryTreePathsTest {
    @Test
    public void testRecursiveSolution() {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> results = binaryTreePaths.binaryTreePaths(null);
        assertEquals(new ArrayList<String>(){}, results);

        // only one node
        TreeNode treeNode = new TreeNode(1);
        results = binaryTreePaths.binaryTreePaths(treeNode);
        assertEquals(new ArrayList<String>(){{add("1");}}, results);

        // root->left
        treeNode.left = new TreeNode(12);
        results = binaryTreePaths.binaryTreePaths(treeNode);
        assertEquals(new ArrayList<String>(){{add("1->12");}}, results);

        // root->[left, right]
        treeNode.right = new TreeNode(34);
        results = binaryTreePaths.binaryTreePaths(treeNode);
        assertEquals(new ArrayList<String>(){{add("1->12");add("1->34");}}, results);

        // root->[left, right][null, right, null, null]
        treeNode.left.right = new TreeNode(56);
        results = binaryTreePaths.binaryTreePaths(treeNode);
        assertEquals(new ArrayList<String>(){{add("1->12->56");add("1->34");}}, results);

        // root->[left, right][null, right, null, null][null, 78]
        treeNode.left.right.right = new TreeNode(78);
        results = binaryTreePaths.binaryTreePaths(treeNode);
        assertEquals(new ArrayList<String>(){{add("1->12->56->78");add("1->34");}}, results);

    }

    @Test
    public void testIterativeSolution() {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> results = binaryTreePaths.binaryTreePathsIterative(null);
        assertEquals(new ArrayList<String>(){}, results);

        // only one node
        TreeNode treeNode = new TreeNode(1);
        results = binaryTreePaths.binaryTreePathsIterative(treeNode);
        assertEquals(new ArrayList<String>(){{add("1");}}, results);

        // root->left
        treeNode.left = new TreeNode(12);
        results = binaryTreePaths.binaryTreePathsIterative(treeNode);
        assertEquals(new ArrayList<String>(){{add("1->12");}}, results);

        // root->[left, right]
        treeNode.right = new TreeNode(34);
        results = binaryTreePaths.binaryTreePathsIterative(treeNode);
        assertEquals(new ArrayList<String>(){{add("1->12");add("1->34");}}, results);

        // root->[left, right][null, right, null, null]
        treeNode.left.right = new TreeNode(56);
        results = binaryTreePaths.binaryTreePathsIterative(treeNode);
        assertEquals(new ArrayList<String>(){{add("1->12->56");add("1->34");}}, results);

        // root->[left, right][null, right, null, null][null, 78]
        treeNode.left.right.right = new TreeNode(78);
        results = binaryTreePaths.binaryTreePathsIterative(treeNode);
        assertEquals(new ArrayList<String>(){{add("1->12->56->78");add("1->34");}}, results);
    }
}
