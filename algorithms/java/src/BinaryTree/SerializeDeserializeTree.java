package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/#/description

public class SerializeDeserializeTree {
    final static char NON = 'x';
    final static String SEPARATOR = ",";

    void serializeTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NON + SEPARATOR);
            return;
        }
        sb.append(root.val + SEPARATOR);
        serializeTree(root.left, sb);
        serializeTree(root.right, sb);
    }

    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();

        serializeTree(root, sb);

        return sb.substring(0, sb.length()-1); // discard ending separator
    }
    TreeNode deserializeTree(Queue<String> nodes) {
        TreeNode root;
        try {
            String cur = nodes.poll();
            int val = Integer.parseInt(cur);
            root = new TreeNode(val);
        } catch (NumberFormatException e) {
            return null;
        }

        root.left = deserializeTree(nodes);
        root.right = deserializeTree(nodes);
        return root;
    }
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Queue<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(SEPARATOR)));
        return deserializeTree(nodes);
    }
}
