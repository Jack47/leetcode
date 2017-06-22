package BinaryTree;

public class ClosestBinarySearchTreeValue {
    boolean closer(double target, int num1, int num2) {
        return Math.abs(num1 - target) < Math.abs(num2 - target);
    }

    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (closer(target, root.val, ret)) {
                ret = root.val;
            }
            root = root.val < target ? root.right : root.left;
        }
        return ret;
    }
}
