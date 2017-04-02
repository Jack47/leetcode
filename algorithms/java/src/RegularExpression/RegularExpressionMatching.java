package RegularExpression;
// 10. Regular Expression Matching
// https://leetcode.com/problems/regular-expression-matching/#/description

// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
public class RegularExpressionMatching {
    public boolean isMatch(String str, String pattern) {
        return isMatch(str, 0, pattern, 0);
    }

    protected boolean isMatch(String str, int i, String pattern, int j) {
        if (str.length() == i  && pattern.length() == j) {
            return true;
        }
        if (pattern.length() == j) {
            return false;
        }
        if (pattern.length() > j + 1 && pattern.charAt(j + 1) == '*') { // `c*`, c match 0 or more times
            return isMatch(str, i, pattern, j + 2) ||
                    (i < str.length() && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')
                      && isMatch(str, i+1, pattern, j) );
        } else {
            return (i < str.length() && str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') && isMatch
                    (str, i + 1, pattern, j + 1);
        }
    }
}
