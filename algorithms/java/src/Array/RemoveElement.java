package Array;
// https://leetcode.com/problems/remove-element/#/description
// Given an array and a value, remove all instances of that value in place and
// return the new length.
// Do not allocate extra space for another array, you must do this in place with
// constant memory.
// The order of elements can be changed. It doesn't matter what you leave beyond
// the new length.

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] != val) {
                i++;
            }
            while (i < j && nums[j] == val) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
                j--;
            }
        }
        if (i == j && nums[i] == val) {

            j--;
        }
        return j + 1;
    }
}
