package BitManipulation;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int j = 0; j <=31; j++) {
            int sum = 0; // 1 bit count
            for(int i = 0; i < nums.length; i++) {
                if((nums[i] & (1 << j)) != 0) {
                    sum++;
                }
            }
            if(sum > 0 && sum %3 == 1) {
                result += (1 <<j);
            }
        }
        return result;
    }
}
