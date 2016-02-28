package SumRootToLeafNumbers;

import static org.junit.Assert.assertEquals;

import TreeNode.TreeNode;
import org.junit.Test;

public class SumRootToLeafNumbersTest {
    @Test
    public void testSum() {
        SumRootToLeafNumbers sumRootToLeaftNumbers = new SumRootToLeafNumbers();
        TreeNode root = null;
        int sum = sumRootToLeaftNumbers.sumNumbers(root);
        assertEquals(0, sum);

        root = new TreeNode(1);
        sum = sumRootToLeaftNumbers.sumNumbers(root);
        assertEquals(1, sum);

        root.left = new TreeNode(2);
        sum = sumRootToLeaftNumbers.sumNumbers(root);
        assertEquals(12, sum);

        root.left.left = new TreeNode(3);
        sum = sumRootToLeaftNumbers.sumNumbers(root);
        assertEquals(123, sum);

        root.right = new TreeNode(4);
        sum = sumRootToLeaftNumbers.sumNumbers(root);
        assertEquals(137, sum);

        root.right.left = new TreeNode(5);
        sum = sumRootToLeaftNumbers.sumNumbers(root);
        assertEquals(268, sum);

        root.right.right = new TreeNode(0);
        sum = sumRootToLeaftNumbers.sumNumbers(root);
        assertEquals(408, sum);
    }
}
