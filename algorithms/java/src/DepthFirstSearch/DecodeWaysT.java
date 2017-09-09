package DepthFirstSearch;

public class DecodeWaysT {
    String s;
    int[] cache;

    int waysOfDecoding(int i) {
        if (i == s.length()) return 1;
        if (cache[i] > 0) return cache[i] - 1;
        char ch = s.charAt(i);
        if (ch == '0') return 0;
        int count = 0;
        if (ch >= '1' && ch <= '9') { // one digit as one letter
            count += 1 * waysOfDecoding(i + 1);
        }
        if (ch == '1' && i + 1 < s.length()) { // two digit as one letter
            char ch2 = s.charAt(i + 1);
            if (ch2 >= '0' && ch2 <= '9') {
                count += 1 * waysOfDecoding(i + 2);
            }
        }
        if (ch == '2' && i + 1 < s.length()) { // two digit as one letter
            char ch2 = s.charAt(i + 1);
            if (ch2 >= '0' && ch2 <= '6') {
                count += 1 * waysOfDecoding(i + 2);
            }
        }
        cache[i] = count + 1;
        return cache[i] - 1;
    }

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        cache = new int[s.length()];
        this.s = s;
        return waysOfDecoding(0);
    }
}
