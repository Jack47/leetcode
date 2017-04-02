package RegularExpression;

public class WildcardMatching {
    // https://leetcode.com/problems/regular-expression-matching/#/description
    // '?' Matches any single character.
    // '*' Matches sequence of characters (including the empty sequence).
    // https://leetcode.com/problems/wildcard-matching/#/description
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    protected boolean isMatch(String s, int i, String p, int j) {
        if (p.length() == j) {
            return s.length() == i;
        }
        if (i > s.length()) {
            return false;
        }
        if (p.charAt(j) == '*') {
            return isMatch(s, i, p, j + 1) || isMatch(s, i + 1, p, j);
        } else {
            return i < s.length() &&
                    (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') &&
                    isMatch(s, i + 1, p, j + 1);
        }
    }
}
