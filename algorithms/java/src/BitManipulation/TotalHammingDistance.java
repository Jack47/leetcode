package BitManipulation;
// https://leetcode.com/problems/total-hamming-distance/#/description
// The Hamming distance between two integers is the number of positions
// at which the corresponding bits are different
// Now your job is to find the total Hamming distance between all paris of the given numbers
// Length of the array will not exceed 10^4
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >>> i) & 1) == 1 ) {
                    count++;
                }
            }
            sum = sum + count * (nums.length - count);
        }
        return sum;
    }
}
