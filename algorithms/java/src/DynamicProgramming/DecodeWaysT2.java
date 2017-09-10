package DynamicProgramming;

public class DecodeWaysT2 {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int e = 1, e1 = 0, e2 = 0;
        for (char ch : s.toCharArray()) {
            int t = e;
            int t1 = e1;
            int t2 = e2;
            e = (ch != '0' ? t : 0) + t1 * 1 + (ch <= '6' ? t2 : 0);
            e1 = ch == '1' ? t * 1 : 0;
            e2 = ch == '2' ? t * 1 : 0;
        }
        return e;
    }
}
