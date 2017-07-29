package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateUniqueBinarySearchTrees {
    int n;
    List<TreeNode>[][] cache;

    List<TreeNode> dfs(int i, int j) {
        if (cache[i][j] != null) return cache[i][j];
        List<TreeNode> results = new ArrayList<>();
        if (i > j) {
            results.add(null);
        }

        for (int k = i; k <= j; k++) {
            List<TreeNode> lefts = dfs(i, k - 1);
            List<TreeNode> rights = dfs(k + 1, j);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(k);
                    root.left = left;
                    root.right = right;
                    results.add(root);
                }
            }
        }
        cache[i][j] = results;
        return results;
    }

    public List<TreeNode> generateTrees(int n) {
        this.n = n;
        if (n == 0) return Collections.emptyList();
        cache = new List[n + 2][n + 2];

        return dfs(1, n);
    }
}
