package BitManipulation;

public class NumberComplement {
    public int findComplement(int num) {
        int leftMostBits = 0;
        leftMostBits = (int) (Math.floor(Math.log10(num) / Math.log10(2)));
        Integer.highestOneBit(num);
        return (1 << (leftMostBits + 1)) - 1 - num;
    }
}
