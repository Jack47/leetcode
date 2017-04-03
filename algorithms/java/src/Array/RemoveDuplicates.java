package Array;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description
// Given a sorted array, remove the duplicates in place such that each element
// appear only once and return the new length.
// Do not allocate extra space for another array, you must do this in place
// with constant memory

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        int next = 1;

        while(next < nums.length) {
            if (nums[next] == nums[cur]) {
                next++;
            } else {
                if (next > cur + 1) {
                    nums[cur+1] = nums[next];
                }
                cur++;
            }
        }
        return cur + 1;
    }
}
