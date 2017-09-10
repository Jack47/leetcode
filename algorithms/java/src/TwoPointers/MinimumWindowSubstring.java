package TwoPointers;

import java.util.Arrays;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] occurrences = new int[128];
        Arrays.fill(occurrences, -1);
        for (char ch : t.toCharArray()) {
            if (occurrences[ch] == -1) {
                occurrences[ch] = 1;
            } else {
                occurrences[ch]++;
            }
        }
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int count = t.length();
        while (i < s.length() && j < s.length()) {
            // window size exceed min size
            // or left start pos doesn't count
            while (i < s.length() && (j - i + 1 > min || occurrences[s.charAt(i)] < 0)) {
                occurrences[s.charAt(i)]++;
                if (occurrences[s.charAt(i)] > 0) {// needs recovery
                    count++;
                }
                i++;
            }

            occurrences[s.charAt(j)]--;
            if (occurrences[s.charAt(j)] >= 0) {
                count--;
                if (count == 0) {
                    if (j - i + 1 < min) {
                        start = i;
                        end = j + 1;
                        min = j - i + 1;
                    }
                }
            }
            j++;
        }
        return s.substring(start, end);
    }
}
