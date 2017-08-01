package BinaryTree;

import org.junit.Test;

public class BSTIteratorTest {
    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        BSTIteratorT b = new BSTIteratorT(root);
        while(b.hasNext()) {
            System.out.println(b.next());
        }
    }
}
