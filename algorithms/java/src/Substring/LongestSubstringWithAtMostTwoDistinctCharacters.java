package Substring;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    final static int kAtMost = 2;

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= kAtMost) return s.length();

        int[] map = new int[128];
        int max = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < s.length()) {
            while (i < s.length() && count > kAtMost) {
                map[s.charAt(i)]--;
                if (map[s.charAt(i)] == 0) {
                    count--;
                }
                i++;
            }
            if (map[s.charAt(j)] == 0) {
                count++;
            }
            if (count <= kAtMost) {
                max = Math.max(max, j-i+1);
            }
            map[s.charAt(j)]++;
            j++;
        }

        return max;
    }
}
