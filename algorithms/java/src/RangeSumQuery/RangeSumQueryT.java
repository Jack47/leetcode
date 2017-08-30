package RangeSumQuery;

public class RangeSumQueryT {
    class SegmentTree {
        int[] nums;
        int[] sums;

        public SegmentTree(int[] nums) {
            if (nums.length == 0) return;
            this.nums = nums;
            int height = (int) Math.ceil(Math.log(nums.length) / Math.log(2)) + 1; // [log2^n]
            int len = (int)Math.pow(2, height) - 1;
            sums = new int[len + 1]; // we use [1 .. 2n-1 .. len, len+1], full binary tree
            construct(1, 0, nums.length - 1);
        }

        void construct(int i, int s, int e) {
            if (s == e) {
                sums[i] = nums[s];
                return;
            }
            int mid = s + (e - s) / 2;
            construct(2 * i, s, mid); // cal left child: sums[2*i]
            construct(2 * i + 1, mid + 1, e); // cal right child: sums[2*i+1]
            sums[i] = sums[2 * i] + sums[2 * i + 1];
        }

        int getSum(int i, int s, int e, int ds, int de) {
            if (s == e) return sums[i];
            int mid = s + (e - s) / 2;
            if (de <= mid) { // go left
                return getSum(2 * i, s, mid, ds, de);
            } else if (de > mid) {
                return getSum(2 * i + 1, mid + 1, e, ds, de);
            } else {
                return getSum(2 * i, s, mid, ds, mid) + getSum(2 * i + 1, mid + 1, e, mid + 1, de);
            }
        }

        public int getSum(int i, int j) {
            return getSum(1, 0, nums.length - 1, i, j);
        }

        void update(int i, int s, int e, int di, int delta) {
            sums[i] += delta;
            if (s == e) return;
            int mid = s + (e - s) / 2;
            if (di <= mid) { // go left
                update(2 * i, s, mid, di, delta);
            } else {
                update(2 * i + 1, mid + 1, e, di, delta);
            }
        }

        public void update(int i, int val) {
            int delta = val - this.nums[i];
            update(1, 0, nums.length - 1, i, delta);
            this.nums[i] = val;
        }
    }

    SegmentTree tree;

    public RangeSumQueryT(int[] nums) {
        tree = new SegmentTree(nums);
    }

    public int sumRange(int i, int j) {
        return tree.getSum(i, j);
    }
}
