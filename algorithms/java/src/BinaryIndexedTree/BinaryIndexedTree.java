package BinaryIndexedTree;

import java.util.Arrays;

public class BinaryIndexedTree {
    int[] BiTree;
    int[] nums;
    public BinaryIndexedTree(int[] nums) {
        BiTree = new int[nums.length + 1];
        this.nums = nums;
        Arrays.fill(BiTree, 0);
        for(int i = 0; i < nums.length;i++) {
            updateBiTree(i, nums[i]);
        }
    }
    public void update (int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        updateBiTree(i, delta);
    }
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
    void updateBiTree(int i, int val) {
        i++;
        while (i < BiTree.length) {// insert all range sums that contain i; up right directions
            BiTree[i] += val;
            i += i & -i; //
        }
    }

    int getSum(int i) {
        i++;
        int ret = 0;
        while (i > 0) {
            ret += BiTree[i];
            i -= i & -i; // collect all the range sums; up left directions
        }
        return ret;
    }
}
