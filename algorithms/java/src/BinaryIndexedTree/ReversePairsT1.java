package BinaryIndexedTree;

public class ReversePairsT1 {
    class TreeNode {
        int val;
        int geCount;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            geCount = 1;
        }
    }

    int search(TreeNode root, int val) {
        if (root == null) return 0;
        if (root.val > val) {  // go left:[val, root.val>, and add root.geCount:[root.val, ..]
            return root.geCount + search(root.left, val);
        } else if (root.val == val) { // find the exact number
            return root.geCount;
        } else {
            return search(root.right, val);
        }
    }

    TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val == val) {
            root.geCount++;
            return root;
        } else if (root.val < val) { // go right side;
            root.geCount++;
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public int reversePairsBST(int[] nums) {
        int count = 0;
        TreeNode head = null;

        for (int num : nums) {
            long dst = 2L * num + 1;
            // avoid overflow, it's out of range
            if (dst >= Integer.MIN_VALUE && dst <= Integer.MAX_VALUE) {
                count += search(head, 2 * num + 1);
            }
            head = insert(head, num);
        }
        return count;
    }
}
