package DynamicProgramming;

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int imax = nums[0];
        int imin = nums[0];
        int max = imax;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = imax;
                imax = imin;
                imin = t;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }

    public int maxProduct(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        int leftMax = maxProduct(nums, left, mid);
        int rightMax = maxProduct(nums, mid + 1, right);
        int toLeftMax = nums[mid];
        int toLeftMin = nums[mid];
        int product = 1;
        for (int i = mid; i >= 0; i--) {
            product *= nums[i];
            toLeftMax = Math.max(product, toLeftMax);
            toLeftMin = Math.min(product, toLeftMin);
        }
        int toRightMax = nums[mid + 1];
        int toRightMin = nums[mid + 1];
        product = 1;
        for (int i = mid + 1; i <= right; i++) {
            product *= nums[i];
            toRightMax = Math.max(product, toRightMax);
            toRightMin = Math.min(product, toRightMin);
        }

        return Math.max(Math.max(leftMax, rightMax), Math.max(toRightMax * toLeftMax,
                toLeftMin * toRightMin));
    }
}
