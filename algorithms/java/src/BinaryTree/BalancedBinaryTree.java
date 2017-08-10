package BinaryTree;

public class BalancedBinaryTree {
    class Result {
        boolean isBalance;
        int height;
        Result(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    Result isBalancedInner(TreeNode root) {
        if(root == null) {
            return new Result(true, 0);
        }
        Result left = isBalancedInner(root.left);
        Result right = isBalancedInner(root.right);
        if(left.isBalance == false || right.isBalance == false || Math.abs(left.height-right.height) > 1) {
            return new Result(false, 0);
        }
        return new Result(true, Math.max(left.height, right.height) + 1);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBalancedInner(root).isBalance;
    }
}
