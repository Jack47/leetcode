package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSumIIT {
    List<List<Integer>> results;
    List<Integer> curResult;
    int sum;

    void dfs(TreeNode root, int curSum) {
        if (root == null) return;
        curSum += root.val;
        curResult.add(root.val);
        if (curSum == sum && root.left == null && root.right == null) {
            results.add(new ArrayList<>(curResult));
            curResult.remove(curResult.size() - 1);
            return;
        }
        dfs(root.left, curSum);
        dfs(root.right, curSum);
        curResult.remove(curResult.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();
        curResult = new ArrayList<>();
        results = new ArrayList<>();
        this.sum = sum;
        dfs(root, 0);
        return results;
    }
}
