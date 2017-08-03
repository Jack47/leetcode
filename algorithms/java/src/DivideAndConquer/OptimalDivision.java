package DivideAndConquer;

public class OptimalDivision {
    class Result {
        String minStr;
        String maxStr;
        float min;
        float max;

        Result(String minStr, float min, String maxStr, float max) {
            this.min = min;
            this.max = max;
            this.minStr = minStr;
            this.maxStr = maxStr;
        }
    }

    int[] nums;
    Result[][] cache;

    Result f(int s, int e) {
        if (cache[s][e] != null) return cache[s][e];

        Result r;
        if (s == e) {
            r = new Result(String.valueOf(this.nums[s]), this.nums[s],
                    String.valueOf(this.nums[s]), this.nums[s]);
            cache[s][e] = r;
            return r;
        }
        r = new Result("", Float.MAX_VALUE, "", Float.MIN_VALUE);
        for (int i = s; i <= e - 1; i++) {
            Result left = f(s, i);
            Result right = f(i + 1, e);
            float min = left.min / right.max;
            float max = left.max / right.min;
            if (min < r.min) {
                r.min = min;
                if (i != e - 1) {
                    r.minStr = left.minStr + "/" + "(" + right.maxStr + ")";

                } else {
                    r.minStr = left.minStr + "/" + right.maxStr;
                }
            }
            if (max > r.max) {
                r.max = max;
                if (i != e - 1) {
                    r.maxStr = left.maxStr + "/" + "(" + right.minStr + ")";
                } else {
                    r.maxStr = left.maxStr + "/" + right.minStr;
                }
            }
        }
        cache[s][e] = r;
        return r;
    }

    public String optimalDivision(int[] nums) {
        this.cache = new Result[nums.length][nums.length];
        this.nums = nums;
        Result result = f(0, nums.length - 1);

        return result.maxStr;
    }
}
