package BinaryTreePaths;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import TreeNode.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * Create all root-to-leaf paths
 * binaryTreePaths is a bit of overloaded, it should be concise: https://leetcode
 * .com/discuss/55451/clean-solution-accepted-without-helper-recursive-function
 */
public class BinaryTreePaths {
    protected List<String> result;
    protected StringBuilder currentPath;

    public BinaryTreePaths() {
        result = new ArrayList<String>();
        currentPath = new StringBuilder();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        result.clear();
        assert currentPath.length() == 0;
        if (root == null) return result;
        visit(root);
        return result;
    }

    protected void visit(TreeNode root) {

        int len = "->".length() + String.valueOf(root.val).length();
        if (root.left == null && root.right == null) {
            String path = currentPath.toString().substring(2, currentPath.length());
            result.add(path);
        }
        if (root.left != null) visit(root.left);
        if (root.right != null) visit(root.right);
        // backtrace

        currentPath.delete(currentPath.length() - len, currentPath.length());
        return;
    }

    public List<String> binaryTreePathsIterative(TreeNode root) {
        Deque<TreeNode> parent = new ArrayDeque<TreeNode>();
        currentPath.setLength(0);
        result.clear();

        TreeNode currentNode = root;
        while (currentNode != null) {
            currentPath.append(root.val + "->");
            if (currentNode.left == null && currentNode.right == null) {
                result.add(currentPath.toString().substring(0, currentPath.length() - 2));
            }

            while (currentNode.left != null) {
                parent.push(currentNode);
                currentNode = currentNode.left;
                currentPath.append(String.valueOf(currentNode.val) + "->");
            }
            while (currentNode.right == null && parent.size() != 0) {
                currentNode = parent.pop();
                backTraceNodePath(currentPath, currentNode);
            }
            currentNode = currentNode.right;
        }
        return result;
    }

    protected void backTraceNodePath(StringBuilder path, TreeNode treeNode) {
        String value = String.valueOf(treeNode.val);
        int index = path.lastIndexOf(value);
        assert index >= 0;
        path.delete(index + value.length() + "->".length(), path.length());
    }

}
