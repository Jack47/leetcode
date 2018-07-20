package RegularExpression;

public class WildCardMatchingT {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p.replace("**", "*"), 0);
    }
    boolean isMatch(String s, int i, String p, int j) {
        if(i== s.length() && j == p.length()) {
            return true;
        }
        if( j >= p.length() || i > s.length()) {
            return false;
        }
        if(p.charAt(j) == '*') {
            // zero
            if(isMatch(s, i, p, j+1)) {
                return true;
            }
            // one
            return isMatch(s, i+1, p, j);
        } else {
            return i < s.length() &&
                    (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) &&
                            isMatch(s, i+1, p, j+1);
        }
    }
}
