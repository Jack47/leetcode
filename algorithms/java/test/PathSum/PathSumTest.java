package PathSum;

import static org.junit.Assert.assertEquals;

import TreeNode.TreeNode;
import org.junit.Test;

public class PathSumTest {
    @Test
    public void test() {
        PathSum pathSum = new PathSum();
        TreeNode root = null;
        boolean result = pathSum.hasPathSum(root, 2);
        assertEquals(false, result);

        root = new TreeNode(5);
        result = pathSum.hasPathSum(root, 2);
        assertEquals(false, result);
        result = pathSum.hasPathSum(root, 5);
        assertEquals(true, result);

        root.left = new TreeNode(4);
        result = pathSum.hasPathSum(root, 9);
        assertEquals(true, result);
        result = pathSum.hasPathSum(root, 5);
        assertEquals(false, result);

        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right= new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        result = pathSum.hasPathSum(root, 22);
        assertEquals(true, result);

        result = pathSum.hasPathSum(root, 26);
        assertEquals(true, result);

        result = pathSum.hasPathSum(root, 27);
        assertEquals(true, result);

        result = pathSum.hasPathSum(root, 28);
        assertEquals(false, result);

        result = pathSum.hasPathSum(root, 18);
        assertEquals(true, result);
    }
}
