package QuickSort;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int left = start;
            int right = end;
            int pivot = nums[left];
            while (left < right) {
                while (left < right && nums[right] > pivot) {
                    right--;
                }
                if(left < right) {
                    nums[left++] = nums[right];
                }

                while (left < right && nums[left] <= pivot) {
                    left++;
                }
                nums[right--] = nums[left];
            }
            if (left == k -1) {
                return nums[left];
            } else if (left < k -1) {
                start = left + 1;
                k = k-1-left;
            } else {
                end = left - 1;
            }
        }
        return -1;
    }
}
