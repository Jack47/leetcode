package DynamicProgramming;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.compareTo("0") == 0) return 0;
        if (s.length() <= 1) return s.length();
        int[] ways = new int[s.length()];
        ways[0] = s.charAt(0) == '0' ? 0 : 1;
        ways[1] = s.charAt(1) == '0' ? 0 : 1;
        int num = Integer.parseInt(s.substring(0, 2));
        if (num <= 9) return 0;
        else if (num <= 26) {
            ways[1] = ways[1] + 1;
        }
        if (ways[1] == 0) return 0;
        for (int i = 2; i < s.length(); i++) {
            ways[i] = (s.charAt(i) == '0' ? 0 : ways[i - 1]);
            num = Integer.parseInt(s.substring(i - 1, i + 1));
            if ( num >= 10 && num <= 26) {
                ways[i] += ways[i - 2];
            }
            if (ways[i] == 0) return 0;
        }
        return ways[s.length() - 1];
    }
}
