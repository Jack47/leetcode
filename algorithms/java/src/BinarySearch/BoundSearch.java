package BinarySearch;

public class BoundSearch {
    public int lower_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int median = left + (right - left) / 2;
            if (nums[median] == target) {
                right = median;
            } else if (nums[median] > target) {
                right = median - 1;
            } else {
                left = median + 1;
            }
        }
        if (nums[left] == target) return left;
        else return -1;

    }

    public int upper_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int median = left + (int)Math.ceil((right - left) / 2.0);
            if (nums[median] < target) {
                left = median + 1;
            } else if (nums[median] > target){
                right = median - 1;
            }
            else {
                left = median;
            }
        }
        if (nums[left] == target) return left;
        else return -1;

    }
}
