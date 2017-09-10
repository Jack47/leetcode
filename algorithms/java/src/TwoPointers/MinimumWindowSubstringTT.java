package TwoPointers;

public class MinimumWindowSubstringTT {
    public String minWindow(String s, String t) {
        int i = 0, j = 0;
        int count = 0;
        int[] frequency = new int[128];
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        for (char ch : t.toCharArray()) {
            frequency[ch]++;
        }

        while (j < s.length()) {
            while (i <= j && (j - i + 1 > minLen || frequency[s.charAt(i)] < 0)) {
                frequency[s.charAt(i)]++;
                if (frequency[s.charAt(i)] > 0) {
                    count--;
                }
                i++;
            }
            frequency[s.charAt(j)]--;
            if (frequency[s.charAt(j)] >= 0) {
                count++;
                if (count == t.length() && j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
            }
            j++;
        }
        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
