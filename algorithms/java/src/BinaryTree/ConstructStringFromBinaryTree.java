package BinaryTree;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder(Integer.toString(t.val));
        if (t.left == null && t.right == null) return sb.toString();
        // either left or right child exists
        sb.append("(");
        sb.append(tree2str(t.left));
        sb.append(")");
        if (t.right != null) { // omit right if t.right is null
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        return sb.toString();
    }
}
