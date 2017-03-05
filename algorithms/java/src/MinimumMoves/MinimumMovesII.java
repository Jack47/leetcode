package MinimumMoves;

public class MinimumMovesII {
    protected int findKth(int k, int[] nums, int begin, int end) {
        int pivot = nums[begin];
        int i = begin, j = end;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i == j) break;
            nums[i++] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j--] = nums[i];
        }
        nums[i] = pivot;
        if (i + 1 < k) {
            return findKth(k, nums, i + 1, end);
        } else if (i + 1 > k) {
            return findKth(k, nums, begin, i - 1);
        }
        return nums[i];
    }

    public int minMoves2(int[] nums) {
        int mid = findKth(nums.length / 2 + 1, nums, 0, nums.length - 1);
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret + Math.abs(nums[i] - mid);
        }
        return ret;
    }
}
