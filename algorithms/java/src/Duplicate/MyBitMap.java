package Duplicate;

public class MyBitMap {
    protected int sizeInBit;
    protected int sizeInWord;
    protected int[] words;
    final protected static int Mask = 0x1F;
    final protected static int Shift = 5;

    public MyBitMap(int sizeInBit) {
        this.sizeInBit = sizeInBit;
        int sizeInWord = (int) Math.ceil((double) sizeInBit / Integer.SIZE);
        this.sizeInWord = sizeInWord <= 12 ? 12 : sizeInWord;
        words = new int[this.sizeInWord];
    }

    public void set(int val) {
        assert val <= sizeInBit : "val[" + val + "] must be smaller than size[" + sizeInBit + "]";
        int index = getIndex(val);
        int bit = getBit(val);
        words[index] = (words[index] | bit);
    }

    public boolean test(int val) {
        int index = getIndex(val);
        int bit = getBit(val);
        if ((words[index] & bit) != 0) {
            return true;
        }
        return false;
    }

    public void clear(int val) {
        int index = getIndex(val);
        int bit = getBit(val);
        words[index] = (words[index] & ~bit);
    }

    protected int getIndex(int val) {
        return val >>> Shift;
    }

    protected int getBit(int val) {
        return 1 << (val & Mask);
    }
}
