package PathSumII;

import java.util.LinkedList;
import java.util.List;

import TreeNode.TreeNode;

public class PathSumII {
    protected List<List<Integer>> pathList;
    public PathSumII() {
        pathList = new LinkedList<List<Integer>>();
    }
    public List<List<Integer>> pathSum(TreeNode root, int expectedSum) {
        int currentSum = 0;
        pathList.clear();

        if (root == null) return pathList;
        List<Integer> currentPath = new LinkedList<Integer>();
        visit(root, currentSum, currentPath, expectedSum);
        return pathList;
    }
    protected void visit(TreeNode root, int currentSum, List<Integer> currentPath, int sum) {
        currentSum += root.val;
        currentPath.add(root.val);
        if (root.left == null && root.right == null && currentSum == sum) {
            pathList.add(new LinkedList<Integer>(currentPath));
        }
        if (root.left != null) {
            visit(root.left, currentSum, currentPath, sum);
        }
        if (root.right != null) {
            visit(root.right, currentSum, currentPath, sum);
        }
        currentPath.remove(currentPath.size()-1); // backtrace
    }
}
