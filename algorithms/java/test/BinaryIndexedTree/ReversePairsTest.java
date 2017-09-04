package BinaryIndexedTree;

import org.junit.Test;

public class ReversePairsTest {
    @Test
    public void test() {
        int[] nums = new int[50000];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        ReversePairsT1 s = new ReversePairsT1();
        int count= s.reversePairs(nums);
        
    }
}
