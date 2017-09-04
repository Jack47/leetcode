package Math;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int moves = 0;

        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for(int num : nums) {
            moves += num-min;
        }
        return moves;
    }
}
