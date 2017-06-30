package BinaryTree;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class SerializeDeserizeBSTTest {
    @Test
    public void test() {
        SerializeBST sol = new SerializeBST();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);

        String result = sol.serialize(root);
        assertEquals("2,x,3,x,x", result);

        root = sol.deserialize(result);

        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        result = sol.serialize(root);
        assertEquals("3,2,1,x,x,6,x,x,4,x,5,x,x", result);
        root = sol.deserialize(result);
    }
}
