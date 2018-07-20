package RegularExpression;

public class RegularExpressionMatchingT {
    public boolean isMatch(String s, String p) {
        // * .
        return isMatch(s, p, 0, 0);
    }
    boolean isMatch(String s, String p, int i, int j) {
        while(j < p.length()) {
            if(i > s.length()) {
                return false;
            }
            if(j < p.length()-1 && p.charAt(j+1) == '*') {
                if(isMatch(s, p, i, j+2)) { // zero
                    return true;
                } else {
                    return (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) && isMatch(s, p, i+1, j);
                }
            }
            if(Character.isAlphabetic(p.charAt(j))) { // alpha
                if(i >= s.length() || s.charAt(i) != p.charAt(j)) {
                    return false;
                }
            } else if(p.charAt(j) == '.') { // this can be deleted, caz it's included in the first case

            }
            i++;
            j++;
        }
        return i == s.length() && j == p.length();
    }
}
