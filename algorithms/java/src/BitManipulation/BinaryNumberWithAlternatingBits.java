package BitManipulation;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int mask = n & 0x1;
        for (int i = 1; i <= 31 && n != 0; i++) {
            if ((0x1 & n) != mask) {
                return false;
            }
            n = n >>> 1;
            mask = (~mask) & 0x1;
        }
        return true;
    }
}
