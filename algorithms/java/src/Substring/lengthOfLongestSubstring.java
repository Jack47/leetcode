package Substring;

import java.util.Arrays;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstringI(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] prevPos = new int[128]; // 128 different kinds of character
        Arrays.fill(prevPos, -1);
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < s.length() && j < s.length()) {
            if (prevPos[s.charAt(j)] == -1 || prevPos[s.charAt(j)] < i) { // this range is ok, may be the longest
            // string
                prevPos[s.charAt(j)] = j;
                max = Math.max(max, j - i + 1);
            } else { // shrink the left
                i = prevPos[s.charAt(j)] + 1;
                prevPos[s.charAt(j)] = j; //
            }
            j++; // advance right pos
        }

        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] count = new int[128];
        int i = 0;
        int j = 0;
        int max = 0;
        while(i < s.length() && j < s.length()) {
            if(count[s.charAt(j)] == 0) {
                max = Math.max(j-i+1, max);
            } else {
                while(count[s.charAt(j)] > 0) {
                    count[s.charAt(i)]--;
                    i++;
                }
            }
            count[s.charAt(j)]++;
            j++;
        }

        return max;
    }
}
