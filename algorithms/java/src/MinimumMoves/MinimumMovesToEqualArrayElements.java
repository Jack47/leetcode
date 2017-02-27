package MinimumMoves;

import java.util.Arrays;
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/?tab=Description
// Given a non-empty integer array of size n, find the minimum number of moves required to
// make all array elements equal, where a move is incrementing n-1 elements by 1.
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            ret += nums[i] - nums[0];
        }
        return ret;
    }
}
