package BinaryTree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SerializeDeserializeTreeTest {
    @Test
    public void test() {
        SerializeDeserializeTree sol = new SerializeDeserializeTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(1);

        String data  = sol.serialize(root);
        assertEquals("5,4,x,3,x,x,6,2,x,1,x,x,x", data);
        TreeNode expected = sol.deserialize(data);
        assertEquals(5, expected.val);
        assertEquals(4, expected.left.val);
        assertEquals(6, expected.right.val);
    }
}
