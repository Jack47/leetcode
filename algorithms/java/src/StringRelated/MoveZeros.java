package StringRelated;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            if (j == 0) { // begin
                j = i + 1;
            }
            while(j < nums.length && nums[j] == 0) {
                j++;
            }
            if(j < nums.length && i < nums.length) {
                nums[i] = nums[j];
                nums[j] = 0;
                j++;
                i++;
            }
        }
    }
}
