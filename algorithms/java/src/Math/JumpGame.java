package Math;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;

        for(int i = nums.length-2; i >= 0; i--) { // the last element's value dones't matter
            if(nums[i] == 0) {
                int needJumps = 1;
                i--;
                while(i >= 0 && nums[i] < needJumps) {
                    i--;
                    needJumps++;
                }
                if(i < 0) return false;
            }
        }
        return true;
    }
    public boolean canJumpTLE(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = nums[0] > 0 ? true : false;
        if(!canReach[0]) return false;
        for (int i = 0; i <= nums.length - 1; i++) {
            int step = nums[i];
            if(i+step >=nums.length-1) {
                return true;
            }
            for (int j = 1; canReach[i] && j <= step && i+j <= nums.length-1; j++) {
                canReach[i+j] = true;
                if(i+j == nums.length-1) {
                    return true;
                }
            }
        }
        return canReach[nums.length-1];
    }
}
