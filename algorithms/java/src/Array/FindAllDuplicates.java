package Array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/#/description
// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
// appear twice and others appear once.
// Find all the elements that appear twice in ths array
// Could you do it without extra space and in O(n) runtime?
public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        int num = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                result.add(num);
            } else {
                nums[num - 1] = -nums[num -1];
            }
        }
        return result;
    }
}
