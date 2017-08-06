package Palindrome;

public class LongestPalindromicSubstringT {
    int start, end;
    int max;
    String s;

    void extendPalindromeStr(int s1, int s2) {
        while (s1 >= 0 && s2 <= s.length() - 1 && s.charAt(s1) == s.charAt(s2)) {
            s1--;
            s2++;
        }
        if (s2 - s1 -1 > max) {
            max = s2 - s1 -1;
            start = s1 + 1;
            end = s2;
        }
    }

    public String longestPalindrome(String s) {
        this.s = s;
        max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindromeStr(i, i);
            extendPalindromeStr(i, i + 1);
        }
        return s.substring(start, end);
    }
}
