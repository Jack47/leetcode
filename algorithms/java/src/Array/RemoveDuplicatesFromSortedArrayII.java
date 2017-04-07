package Array;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/#/description
// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        int next = 1;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length >= 2 && nums[0] == nums[1]) {
            cur = 1;
            next = 2;
        }
        while(cur < nums.length && next < nums.length) {
            while(next < nums.length && nums[cur] == nums[next]) {
                next++;
            }
            if (next < nums.length) {
                nums[cur + 1] = nums[next];
                if (next + 1 < nums.length && nums[next] == nums[next+1]) {
                    cur++;
                    next++;
                    nums[cur + 1] = nums[next];
                }
            } else {
                break; // don't plus cur
            }
            cur++;
            next++;
        }
        return cur + 1;
    }
}
