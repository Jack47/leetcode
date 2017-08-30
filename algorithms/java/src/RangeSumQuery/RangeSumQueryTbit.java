package RangeSumQuery;

public class RangeSumQueryTbit {
    int[] biTree;
    int[] nums;

    public RangeSumQueryTbit(int[] nums) {
        if (nums.length == 0) return;
        biTree = new int[nums.length + 1]; // [1..n]
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            updateBiTree(i, nums[i]);
        }
    }

    void updateBiTree(int i, int delta) {
        i++;
        while (i < biTree.length) { // i <= n
            biTree[i] += delta;
            i += i & (-i);
        }
    }

    public void update(int i, int val) {
        updateBiTree(i, val - this.nums[i]);
        this.nums[i] = val;
    }

    int getSum(int i) {
        i++;
        int sum = 0;
        while (i >= 1) { // >= 1
            sum += biTree[i];
            i -= i & (-i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}
