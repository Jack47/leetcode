package BitManipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int reversed = 0;
        int counter = 0;
        while (counter < 32) {
            reversed = (reversed << 1) + (n & 1);
            n = n >>> 1;
            counter++;
        }

        return reversed;
    }
}
