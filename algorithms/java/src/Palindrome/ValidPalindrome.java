package Palindrome;

public class ValidPalindrome {
    boolean isAlphaNumeric(char ch) {
        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }
    boolean ignoreCaseAlphaNumbericEqual(char ch1, char ch2) {
        if(Character.isDigit(ch1) && ch1 == ch2) return true;
        if(Character.toLowerCase(ch1) == Character.toLowerCase(ch2)) return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int i = 0, j = s.length()-1;
        while(i < j) {
            while(i < j && !isAlphaNumeric(s.charAt(i))) i++;
            while(i < j && !isAlphaNumeric(s.charAt(j))) j--;
            if(!ignoreCaseAlphaNumbericEqual(s.charAt(i), s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
