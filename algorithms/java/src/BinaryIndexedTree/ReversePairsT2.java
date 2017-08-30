package BinaryIndexedTree;

import java.util.Arrays;

public class ReversePairsT2 {
    int[] biTree;

    // how to find ceiling element
    int binarySearchGE(int[] nums, int num) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= num) {
                r = m - 1; // as left as possible
            } else {
                l = m + 1;
            }
        }
        return l; // l > r;
    }

    // search elements count that is ge to i, so go to right
    int search(int[] biTree, int i) {
        i++;
        int count = 0;
        while (i < biTree.length) {
            count += biTree[i];
            i += i & (-i);
        }
        return count;
    }

    // add i to this biTree, it's bigger than [0..i-1], so go to parent nodes
    void update(int[] biTree, int i) {
        i++;
        while (i >= 1) {
            biTree[i] += 1; //
            i -= i & (-i);
        }
    }

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        biTree = new int[nums.length + 1];
        int[] cp_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cp_nums);
        int count = 0;
        for (int num : nums) {
            long d = 2L * num + 1;
            if (d < Integer.MIN_VALUE) {
                d = Integer.MIN_VALUE;
            }
            if (d <= Integer.MAX_VALUE) {
                int i = binarySearchGE(cp_nums, (int)d);
                count += search(biTree, i);
            } // else i = biTree.length, so search() == 0

            update(biTree, binarySearchGE(cp_nums, num));
        }
        return count;
    }
}
