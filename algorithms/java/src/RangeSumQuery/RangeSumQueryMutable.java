package RangeSumQuery;

public class RangeSumQueryMutable {
    protected int[] nums;
    protected int[] sums;
    protected int invalidSumsStartIndex;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        invalidSumsStartIndex = 0;
    }

    public int sumRange(int i, int j) {
        if (j >= invalidSumsStartIndex) {
            int sum = invalidSumsStartIndex > 0 ? sums[invalidSumsStartIndex - 1] : 0;
            for (int k = invalidSumsStartIndex; k <= j; k++) {
                sum += nums[k];
                sums[k] = sum;
            }
            invalidSumsStartIndex = j + 1;
        }
        return sums[j] - (i > 0 ? sums[i - 1] : 0);
    }

    public void update(int i, int val) {
        nums[i] = val;
        if (i < invalidSumsStartIndex) {
            invalidSumsStartIndex = i;
        }
    }
}
