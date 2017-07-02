package StringRelated;

class Reader4 {
    public int read4(char[] buf) {
        return 0;
    }
}

public class ReadNCharactersGivenRead4 extends Reader4 {
    void copy(char[] sbuf, int src, char[] dbuf, int dst, int len) {
        for (int i = 0; i < len; i++) {
            dbuf[dst + i] = sbuf[src + i];
        }
    }

    public int read(char[] buf, int n) {
        int count = 0;
        char[] tbuf = new char[4];
        int tn = n;

        while (tn > 0) {
            int c = read4(tbuf);
            c = Math.min(tn, c);
            copy(tbuf, 0, buf, count, c);
            count += c;
            tn = tn - c;
            if (c < 4) {
                break;
            }
        }
        return count;
    }
}
