package Array;

// https://leetcode.com/problems/product-of-array-except-self/#/description
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int[] p1 = new int[nums.length];
        p1[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            p1[i] = p1[i-1]*nums[i-1]; // 1, n0, n0*n1, n0*n1*n2
        }

        int p2 = 1;
        for (int i = nums.length -2; i >= 0; i--) {
            p2 = p2*nums[i+1];        // n0*n1*n2, n1*n2, n2, 1
            p1[i] = p2*p1[i];
        }
        return p1;
    }
}
