package BitManipulation;

public class ReverseInteger {
    public int reverse(int x) {
        int reversedX = 0;
        while (x != 0) {
            if ((reversedX * 10) / 10 != reversedX) {
                return 0;
            }
            reversedX = reversedX * 10 + x % 10;
            x = x / 10;
        }
        return reversedX;
    }
}
