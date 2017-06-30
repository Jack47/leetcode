package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {
    // Encodes a tree to a single string.
    final static String SEPARATOR = ",";
    final static String NULL = "x";

    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrderVisit(sb, root);
        return sb.substring(0, sb.length() - 1);
    }

    void preOrderVisit(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(NULL);
            sb.append(SEPARATOR);
            return;
        }
        sb.append(root.val);
        sb.append(SEPARATOR);

        preOrderVisit(sb, root.left);
        preOrderVisit(sb, root.right);
    }

    TreeNode getNode(String str) {
        if (str.compareTo(NULL) == 0) {
            return null;
        }
        return new TreeNode(Integer.parseInt(str));
    }

    TreeNode preOrderCreate(Queue<String> q) {
        TreeNode root = getNode(q.poll());
        if(root == null) return root;
        root.left = preOrderCreate(q);
        root.right = preOrderCreate(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] strs = data.split(SEPARATOR);
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(SEPARATOR)));

        return preOrderCreate(q);
    }
}
