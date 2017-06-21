package BinarySearch;

public class SearchInRotatedSortedArray {
    int searchPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left] && nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return nums[left] == target ? left : -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int pivot = searchPivot(nums);
        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivot, nums.length, target);
        } else {
            return binarySearch(nums, 0, pivot, target);
        }
    }
}
