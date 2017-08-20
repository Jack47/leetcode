package DynamicProgramming;

public class OnesAndZeros {
    int[] getZerosAndOnes(String s) {
        int[] result = new int[2];
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                result[1]++;
            } else {
                result[0]++;
            }
        }
        return result;
    }

    public int findMaxFormON3(String[] strs, int m, int n) {
        if (strs.length == 0) return 0;
        int[][] nums = new int[strs.length][2];

        for (int i = 0; i < strs.length; i++) {
            nums[i] = getZerosAndOnes(strs[i]);
        }

        int[][][] dp = new int[nums.length + 1][m + 1][n + 1];
        for (int k = 1; k <= nums.length; k++) {
            int[] num = nums[k - 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i >= num[0] && j >= num[1]) {
                        dp[k][i][j] = Math.max(dp[k - 1][i][j], dp[k - 1][i - num[0]][j - num[1]]
                                + 1);
                    } else {
                        dp[k][i][j] = dp[k - 1][i][j];
                    }

                }
            }
        }
        return dp[nums.length][m][n];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) return 0;
        int[][] nums = new int[strs.length][2];

        for (int i = 0; i < strs.length; i++) {
            nums[i] = getZerosAndOnes(strs[i]);
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int k = 1; k <= nums.length; k++) {
            int m0 = nums[k - 1][0];
            int n1 = nums[k - 1][1];
            for (int i = m; i >= m0; i--) {
                for (int j = n; j >= n1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - m0][j - n1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
