package BitManipulation;
// Write a function that takes an unsigned integer and returns the number of
// '1' bits
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n>>>1;
        }
        return count;
    }
    public int hammingWeight2(int n) {
        int count = 0;
        while ( n != 0) {
            count++;
            // Each time of "n&(n-1)", we delete one '1' from n.
            // Use bit mask to extract bit of n 1 by 1.
            // "n & (n-1)" is used to delete the right "1" of binary n;
            n = n & (n-1);
        }
        return count;
    }
}
