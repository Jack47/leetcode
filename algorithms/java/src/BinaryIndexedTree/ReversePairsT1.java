package BinaryIndexedTree;

import java.util.Arrays;

public class ReversePairsT1 {
    class TreeNode {
        int val;
        int geCount;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            geCount = 0; // NOTE
        }
    }

    int search(TreeNode root, long val) {
        if (root == null) return 0;
        if (root.val > val) {  // go left:[val, root.val>, and add root.geCount:[root.val, ..]
            return root.geCount + search(root.left, val);
        } else if (root.val == val) { // find the exact number
            return root.geCount;
        } else {
            return search(root.right, val);
        }
    }

    TreeNode construct(int[] nums, int left, int right) {
        if (left > right) return null;
        int m = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = construct(nums, left, m - 1);
        root.right = construct(nums, m + 1, right);
        return root;
    }

    TreeNode update(TreeNode root, int val) {
        if (root.val == val) {
            root.geCount++;
            return root;
        } else if (root.val < val) { // go right side;
            root.geCount++;
            update(root.right, val);
        } else {
            update(root.left, val);
        }
        return root;
    }

    public int reversePairs(int[] nums) {
        int count = 0;
        int[] cp_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cp_nums);
        TreeNode head = construct(cp_nums, 0, nums.length - 1);

        for (int num : nums) {
            count += search(head, 2L * num + 1);
            head = update(head, num);
        }
        return count;
    }

}
