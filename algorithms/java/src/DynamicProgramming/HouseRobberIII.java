package DynamicProgramming;

public class HouseRobberIII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] innerRob(TreeNode root) {
        int[] results = new int[2]; // 0: robMax; 1: noRobMax;
        if (root.left == null && root.right == null) {
            results[0] = root.val;
            return results;
        }

        int[] left = null;
        int[] right = null;

        if (root.left != null) {
            left = innerRob(root.left);
        }
        if (root.right != null) {
            right = innerRob(root.right);
        }
        results[0] = root.val + (left != null ? left[1] : 0) + (right != null ? right[1] : 0);
        int leftMax = left != null ? Math.max(left[0], left[1]) : 0;
        int rightMax = right != null ? Math.max(right[0], right[1]) : 0;
        results[1] = leftMax + rightMax;
        return results;
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] results = innerRob(root);
        return Math.max(results[0], results[1]);
    }
}
