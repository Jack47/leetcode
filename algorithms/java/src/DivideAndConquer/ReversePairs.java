package DivideAndConquer;

import java.util.Arrays;

public class ReversePairs {
    int mergeCount(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int m = left + (right - left) / 2;
        int count = 0;
        count += mergeCount(nums, left, m);
        count += mergeCount(nums, m + 1, right);

        int j = m + 1;
        // nums[i] > nums[j]*2;
        for (int i = left; i <= m; i++) {
            if (nums[i] / 2.0 > nums[j]) {
                while (j + 1 <= right && nums[j + 1] < nums[i] / 2.0) {
                    j++;
                }
                count += j - m;
            }
        }

        Arrays.sort(nums, left, right + 1);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeCount(nums, 0, nums.length - 1);
    }
}
