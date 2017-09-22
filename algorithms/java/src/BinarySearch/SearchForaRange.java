package BinarySearch;

public class SearchForaRange {
    int firstGreaterOrEqual(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] >= target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        if (nums.length == 0) return result;

        int i = firstGreaterOrEqual(nums, target);
        if (i == nums.length || nums[i] != target) return result;
        int j = firstGreaterOrEqual(nums, target + 1);
        result[0] = i;
        result[1] = j - 1;
        return result;
    }
}
