package PathSumII;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import TreeNode.TreeNode;
import org.junit.Test;

public class PathSumIITest {
    @Test
    public void test() {
        PathSumII pathSumII = new PathSumII();

        TreeNode root = null;
        List<List<Integer>> paths = pathSumII.pathSum(root, 0);
        assertEquals(0, paths.size());

        root = new TreeNode(5);
        paths = pathSumII.pathSum(root, 5);
        assertEquals(1, paths.size());
        assertEquals((Integer)5, paths.get(0).get(0));

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        paths = pathSumII.pathSum(root, 20);
        assertEquals(1, paths.size());
        assertEquals(new LinkedList<Integer>() {{add(5);add(4);add(11);}}, paths.get(0));

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        paths = pathSumII.pathSum(root, 5);
        assertEquals(0, paths.size());

        paths = pathSumII.pathSum(root, 22);
        assertEquals(1, paths.size());
        assertEquals(new LinkedList<Integer>() {{add(5);add(4);add(11);add(2);}}, paths.get(0));

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        paths = pathSumII.pathSum(root, 22);
        assertEquals(2, paths.size());
        assertEquals(new LinkedList<Integer>() {{add(5);add(4);add(11);add(2);}}, paths.get(0));
        assertEquals(new LinkedList<Integer>() {{add(5);add(8);add(4);add(5);}}, paths.get(1));
    }
}
