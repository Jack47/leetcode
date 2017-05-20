package BinaryTree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LevelOrderTraversalTest {
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal sol = new LevelOrderTraversal();
        List<List<Integer>> result = sol.levelOrder(root);
        List<List<Integer>> expected = new ArrayList<List<Integer>>(){
            {
                add(new ArrayList<Integer>(){
                    {
                        add(3);
                    }
                });
                add(new ArrayList<Integer>(){
                    {
                        add(9);
                        add(20);
                    }
                });
                add(new ArrayList<Integer>(){
                    {
                        add(15);
                        add(7);
                    }
                });
            }
        };

        assertEquals(expected, result);
    }
}
