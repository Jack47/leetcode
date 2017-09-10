package DepthFirstSearch;

public class DecodeWaysII {
    String s;

    int ways(int i) {
        if (i == s.length()) return 1;
        char ch = s.charAt(i);
        if (ch == '0') return 0;
        int count = 0;
        if (ch == '*') {
            count += 9 * ways(i + 1); // single digit
            if (i + 1 < s.length()) { // two digit
                char ch2 = s.charAt(i + 1);
                if (ch2 >= '0' && ch2 <= '9') {
                    count += 1 * ways(i + 2); // * as 1 1d
                    if (ch2 <= '6') { // * as 2 => 2d
                        count += 1 * ways(i + 2);
                    }
                }
            }
        } else { // digit
            count += 1 * ways(i + 1); // single digit
            if (i + 1 < s.length()) {
                char ch2 = s.charAt(i + 1);
                if (ch <= '2' && ch2 == '*') { // can combine: [1-2]*
                    count += 1 * ways(i + 2);
                }
                if (ch == '1' && ch2 >= '0' && ch2 <= '9') { // two digit
                    count += 1 * ways(i + 2);
                }
                if (ch == '2' && ch2 >= '0' && ch2 <= '6') {
                    count += 1 * ways(i + 2);
                }
            }
        }
        return count;
    }

    // Because of stack size limit, if s.length is very big, this solution will cause stack overflow
    public int numDecodingsTLE(String s) {
        if (s.length() == 0) return 0;
        this.s = s;
        return ways(0);
    }

    int mod = 1000000000+7;
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        long e = 1, e1 = 0, e2 = 0;
        for (char ch : s.toCharArray()) {
            long t = e;
            long t1 = e1;
            long t2 = e2;
            if (ch == '*') {
                e = (9L * t + 9 * t1 + 6 * t2);
                e1 = t;
                e2 = t;
            } else {
                e = (ch != '0' ? 1 * t : 0) + 1L * t1 + (ch <= '6' ? 1 * t2 : 0);
                e1 = ch == '1' ? 1 * t : 0;
                e2 = ch == '2' ? 1 * t : 0;
            }
            String.valueOf(12);
            e = e % mod;
        }
        return (int)e;
    }
}
