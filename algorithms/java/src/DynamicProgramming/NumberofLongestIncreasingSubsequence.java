package DynamicProgramming;

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] lens = new int[nums.length];
        lens[0] = 1;
        int[] counts = new int[nums.length];
        counts[0] = 1;
        int count;
        int curMaxLen;

        for (int i = 1; i < nums.length; i++) {
            curMaxLen = 1;
            count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lens[j] + 1 >= curMaxLen) {
                    if (lens[j] + 1 > curMaxLen) {
                        curMaxLen = lens[j] + 1;
                        count = counts[j];
                    } else {
                        count += counts[j];
                    }
                }
            }
            lens[i] = curMaxLen;
            counts[i] = count;
        }
        // find maxLen
        int maxLen = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lens[i] > maxLen) {
                maxLen = lens[i];
                maxCount = counts[i];
            } else if (lens[i] == maxLen) {
                maxCount += counts[i];
            }
        }
        return maxCount;
    }
}
