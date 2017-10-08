package Palindrome;

public class ShortestPalindrome {
    int endPos;
    int max;
    String s;

    void extendingPalindrome(int ending) {
        int start = 0, end = ending;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (end <= start && ending + 1 > max) { // it's palindrome
            max = ending + 1;
            endPos = ending;
        }
    }

    public String shortestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        this.s = s;
        max = 1;
        endPos = 0;
        int n = s.length();
        for (int i = 1; i <= n - 1; i++) {
            extendingPalindrome(i);
        }
        StringBuilder sb = new StringBuilder(s.substring(endPos + 1));
        String reverse = sb.reverse().toString();
        return reverse + s;
    }
}
