package RangeSumQuery;

public class RangeSumQueryMutable {
    protected int[] nums;
    protected int[] tree;
    protected boolean initialized;
    protected int delta;
    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        if (nums.length == 0) return;
        int height = (int) (Math.ceil(Math.log(nums.length) / Math.log(2)));
        int maximumNodes = (int) (Math.pow(2, height + 1) - 1);
        tree = new int[maximumNodes + 1];
        initialized = false;
    }

    public int sumRange(int i, int j) {
        if (!initialized) {
            constructSumRange(1, nums.length, 1);
            initialized = true;
        }
        return sumRangeInner(i + 1, j + 1, 1, nums.length, 1);
    }

    protected int sumRangeInner(int i, int j, int currentI, int currentJ, int count) {
        int median = currentI + (currentJ - currentI) / 2;
        if (currentI == currentJ) return tree[count];
        if (j <= median) {
            return sumRangeInner(i, j, currentI, median, 2 * count);
        } else if (i > median) {
            return sumRangeInner(i, j, median + 1, currentJ, 2 * count + 1);
        } else {
            int leftSum = sumRangeInner(i, median, currentI, median, 2 * count);
            int rightSum = sumRangeInner(median + 1, j, median + 1, currentJ, 2 * count + 1);
            return leftSum + rightSum;
        }
    }

    public void update(int i, int val) {
        this.delta = val-this.nums[i];
        this.nums[i] = val;
        updateInner(i+1, 1, nums.length, 1);
    }

    protected void updateInner(int i, int currentI, int currentJ, int count) {
        if (currentI == currentJ) {
            tree[count] = nums[i-1];
            return;
        }
        int median = currentI + (currentJ-currentI)/2;
        tree[count] = tree[count] + delta;
        if (i <= median) {
            updateInner(i, currentI, median, 2*count);
        }
        else {
            updateInner(i, median+1, currentJ, 2*count+1);
        }
    }
    protected int constructSumRange(int i, int j, int count) {
        if (i == j) {
            tree[count] = nums[i - 1];

        } else {
            int median = i + (j - i) / 2;
            int leftSum = constructSumRange(i, median, 2 * count);
            int rightSum = constructSumRange(median + 1, j, 2 * count + 1);
            tree[count] = leftSum + rightSum;
        }
        return tree[count];
    }
}
