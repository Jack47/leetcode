package Array;

import java.util.Arrays;
// https://leetcode.com/problems/majority-element/#/description
// Given an array of size n, find the majority element. The majority
// element is the element that appears **more than** n/2 times.
// So there at most one element

// You may assume that array is non-empty and the majority element always exist in the array.
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length-1)/2];
    }
    public int majorityElement2(int[] nums) {
        int m  = nums[0]; // the array is non-empty
        int count = 1;
        for (int num : nums) {
            if (count == 0) {
                m = num;
                count++;
            } else if (m != num) {
                count--;
            } else {
                count++;
            }
        }
        return m;
    }
}
