package StringRelated;

public class ReadNCharactersGivenRead4II extends Reader4 {
    char[] tbuf;
    int ti;
    int tn;
    public ReadNCharactersGivenRead4II() {
        tbuf = new char[4];
        ti = 0;
        tn = 0;
    }

    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (ti == 0) {
               // tn = read4(tbuf);
            }
            if(tn == 0) break; // if (tn < 4) break; // it's the end
            buf[i++] = tbuf[ti++];
            if (ti == tn) {
                ti = 0;
            }
        }
        return i;
    }
}
