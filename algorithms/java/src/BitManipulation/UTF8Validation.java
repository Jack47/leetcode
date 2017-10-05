package BitManipulation;

public class UTF8Validation {
    int getN(int data) {
        int n = 0;
        int i = 7;
        while ((data & (1 << i)) != 0 && n < 7) {
            n++;
            i--;
        }
        return (data & (1 << i)) == 0 ? n : -n;
    }

    boolean checkContinuation(int[] data, int i, int n) {
        while (n > 0 && i < data.length && (data[i] & 0xC0) == 0x80) {
            i++;
            n--;
        }
        return n == 0;
    }

    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            // MSB is zero
            if ((data[i] & 0x80) == 0) {
                i++;
            } else {
                // get total n bytes from first byte
                int n = getN(data[i]);
                i++;
                if (n == 1 || n > 4 || n < 0) return false;
                if (!checkContinuation(data, i, n - 1)) {
                    return false;
                }
                i += n - 1;
            }
        }
        return true;
    }
}
