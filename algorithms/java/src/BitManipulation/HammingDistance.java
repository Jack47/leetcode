package BitManipulation;
// The Hamming distance between two integers is the number of positions at which
// the corresponding bits are different
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while(z > 0) {
            if ((z & 1) == 1) {
                count++;
            }
            z = z >> 1;
        }
        return count;
    }
}
