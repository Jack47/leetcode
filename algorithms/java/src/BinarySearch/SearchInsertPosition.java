package BinarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }
    protected int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int median = left + (right-left)/2;
            if (nums[median] < target) {
                left = median+1;
            }
            else if (nums[median] > target) {
                right = median-1;
            }
            else {
                return median;
            }
        }
        return left;
    }
}
