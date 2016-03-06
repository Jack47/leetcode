package LowestCommonAncestor;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;

public class BinaryTree {
    List<TreeNode> ppath;
    List<TreeNode> qpath;
    // Store root to p(q)'s path
    List<TreeNode> path;
    boolean flip;

    public BinaryTree() {
        ppath = null;
        qpath = null;
        path = new ArrayList<TreeNode>();
        flip = false;
    }

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else return left != null ? left : right;
    }

    /**
     *
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(final TreeNode root, final TreeNode p, final TreeNode q) {

        if (root == null) return null;
        path.clear();
        visit(root, p, q);
        if (qpath == null || ppath == null) return null;
        return lowestCommonAncestor(qpath, ppath);
    }

    void visit(final TreeNode root, final TreeNode p, final TreeNode q) {
        path.add(root);

        if (root == p) {
            ppath = new ArrayList<TreeNode>(path);
        } else if (root == q) {
            qpath = new ArrayList<TreeNode>(path);
        }

        if (root.left != null) visit(root.left, p, q);
        if (root.right != null) visit(root.right, p, q);
        path.remove(path.size() - 1);
    }

    TreeNode lowestCommonAncestor(List<TreeNode> qpath, List<TreeNode> ppath) {
        int i = 0;
        for (i = 0; i <= qpath.size() - 1 && i <= ppath.size() - 1; i++) {
            if (qpath.get(i).val != ppath.get(i).val) {
                break;
            }
        }
        return qpath.get(i - 1);
    }
}
