package BinaryTree;

import org.junit.Test;

public class InOrderTravsersalTest {
    @Test
    public void test() {
        InOrderTraversal sol = new InOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        sol.inorderTraversal(root);
    }
}
