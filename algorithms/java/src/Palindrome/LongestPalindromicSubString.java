package Palindrome;

public class LongestPalindromicSubString {
    boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i == j;
    }

    public String longestPalindromeTLE(String s) {
        if (s.length() <= 1) return s;
        int maxLen = 0;
        String max = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i && j + 1 - i >= maxLen; j--) {
                String str = s.substring(i, j + 1);
                if (isPalindrome(str) && str.length() > maxLen) {
                    maxLen = str.length();
                    max = str;
                }
            }
        }
        return max;
    }

    String s;
    int maxLen;
    int start;

    void extendPalindrome(int i, int j) {

        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            maxLen = j - i - 1;
            start = i+1;
        }
    }

    public String longestPalindrome(String s) {
        maxLen = 0;
        start = 0;
        this.s = s;
        for (int i = 0; i <= s.length() - 1; i++) {
            extendPalindrome(i, i); // odd string
            extendPalindrome(i, i + 1); // event string
        }
        return s.substring(start, start + maxLen);
    }
}
