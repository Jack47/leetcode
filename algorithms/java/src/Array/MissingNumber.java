package Array;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = (nums.length - 1);
        long sums = (long) (n) * n / 2 + n / 2;
        for (int num : nums) {
            sums -= num;
        }
        return (int)sums;
    }
}
