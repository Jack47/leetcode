package BitManipulation;

public class NumberOf1BitsT {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int mask = 1; //
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((mask & n) != 0) {
                count++;
            }
            mask = mask << 1; // or 1 << i; or n >>> 1;
        }
        return count;
    }
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n-1); // n -= n & (-n);
        }
        return count;
    }
}
