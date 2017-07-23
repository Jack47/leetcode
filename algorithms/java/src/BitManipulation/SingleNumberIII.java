package BitManipulation;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor = num ^ xor;
        }
        // xor = A^B
        int lowestBit = xor & -xor;
        int[] result = new int[2];
        result[0] = xor;
        result[1] = xor;

        for(int num : nums) {
            if( (num & lowestBit) != 0) {
                result[0] = result[0] ^ num;
            } else {
                result[1] = result[1] ^ num;
            }
        }
        return result;
    }
}
