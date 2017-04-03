package Array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/description
// Given an array of integers where 1 <= a[i] <= n( n = size of array), some
// elements appear twice and others appear once.
// Find all the elements of [1, n] inclusive that do not appear in this array
public class FindAllDisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;
            nums[num] = nums[num] > 0 ? -nums[num] : nums[num];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
