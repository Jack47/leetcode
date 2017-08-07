package Palindrome;

public class PalindromicSubstrings {
    int count;
    String s;
    void extendPalindromicSubstrin(int s1, int s2) {
        if(s2 == s.length()) {
            return;
        }
        while(s1>=0 && s2 <= s.length()-1 && s.charAt(s1) == s.charAt(s2)) {
            count++;
            s1--;
            s2++;
        }

    }
    public int countSubstrings(String s) {
        count = 0;
        this.s = s;
        for(int i = 0; i < s.length(); i++) {
            extendPalindromicSubstrin(i, i); // odd length
            extendPalindromicSubstrin(i, i+1); // even length
        }
        return count;
    }
}
