package BinaryTree;

public class LargestBSTSubTree {
    class Result {
        boolean isBST;
        int size;
        int min;
        int max;
        Result(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    Result postOrder(TreeNode root) {
        if(root == null) return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result l = postOrder(root.left);
        Result r = postOrder(root.right);
        if(!l.isBST || !r.isBST || l.max >= root.val || r.min <= root.val) {
            return new Result(false, Math.max(l.size, r.size), 0, 0);
        }
        return new Result(true, 1+l.size+r.size, Math.min(l.min, root.val), Math.max(root.val, r.max));
    }
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        return postOrder(root).size;
    }
}
