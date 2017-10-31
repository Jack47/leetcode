package BinarySearch;

public class SearchBitonicArray {
    public int searchBitonicArray(int[] nums, int value) {
        if (nums.length == 0) return 0;
        return searchBitonicArray(nums, value, 0, nums.length);
    }

    int searchBitonicArray(int[] nums, int value, int s, int e) {
        if (s > e) return -1;
        int mid = s + (e - s) / 2;
        if(nums[mid] == value) return mid;
        else if (nums[mid] < nums[s]) {
            if(value < nums[mid]) {
                return searchBitonicArray(nums, value, mid+1, e);
            }
            return searchBitonicArray(nums, value, s, mid-1);
        } else {
            // int r = searchBitonicArray(nums, value, mid)
        }
        return -1;
    }
}
