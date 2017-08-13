package Duplicate;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums.length == 2) return nums[0];
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
