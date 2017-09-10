package TwoPointers;

public class MinimumWindowSubstringT {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int i = 0, j = 0;
        int minSize = s.length() + 1, start = 0;
        int[] freq = new int[128];
        int count = 0;

        for (char ch : t.toCharArray()) {
            freq[ch]++;
            if (freq[ch] == 1) {
                count++;
            }
        }

        while (j < s.length()) {
            char ch = s.charAt(i);
            while (i < j && (j - i + 1 > minSize || freq[ch] < 0)) {
                freq[ch]++;
                if (freq[ch] == 1) {
                    count++;
                }
                i++;
                ch = s.charAt(i);
            }
            ch = s.charAt(j);
            freq[ch]--;
            if (freq[ch] == 0) {
                count--;
                if (count == 0 && minSize > j - i + 1) {
                    minSize = j - i + 1;
                    start = i;
                }
            }
            j++;
        }
        minSize = minSize == s.length() + 1 ? 0 : minSize;
        return s.substring(start, start + minSize);
    }
}
