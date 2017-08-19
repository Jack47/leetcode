package Graph;

public class ArithmetricSlice {
    public int numberOfArithmeticSlicesBruteForce(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] != nums[j - 1] - nums[j - 2]) {
                    break;
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public int numberOfArithmeticSlicesDP(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int count = 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int count = 0;
        int i = 0, j;

        while (i < nums.length) {
            j = i + 2;
            while (j < nums.length && nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2]) {
                j++;
            }
            if (j - i >= 3) {
                int m = j - i - 3;
                count += 2 * m + 1 + m * (m - 1) / 2;
            }
            i = j - 1;
        }
        return count;
    }
}
