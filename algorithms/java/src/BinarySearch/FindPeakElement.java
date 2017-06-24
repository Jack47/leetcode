package BinarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        while(s < e) {
            int mid1 = s+(e-s)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2]) {
                s = mid2;
            } else {
                e = mid1;
            }
        }
        return nums[s];
    }
}
