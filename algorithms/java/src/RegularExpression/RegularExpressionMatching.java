package RegularExpression;
// 10. Regular Expression Matching
// https://leetcode.com/problems/regular-expression-matching/#/description

// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
public class RegularExpressionMatching {
    public boolean isMatch(String str, String pattern) {
        int j = 0;
        int i = 0;
        char preceding = 0;
        if (str.isEmpty() && pattern.isEmpty()) {
            return true;
        }
        while (i < pattern.length() && j < str.length()) {
            if (pattern.charAt(i) == '.') {
                preceding = '.';
                i++;
                j++;
            } else if (pattern.charAt(i) == '*') {
                int counter = 0;
                if (isMatch(str.substring(j - 1), pattern.substring(i + 1))) { // "a*aa", "aa";
                    return true;
                }
                do {
                    if (isMatch(str.substring(j + counter), pattern.substring(i + 1))) {
                        return true;
                    }
                    counter++;
                }
                while (j + counter <= str.length() && (str.charAt(j + counter - 1) == preceding
                        || preceding == '.'));
                return false;
            } else if (str.charAt(j) == pattern.charAt(i)) {
                preceding = pattern.charAt(i);
                i++;
                j++;
            } else if (i + 1 < pattern.length() && pattern.charAt(i + 1) == '*') { // "b*a", "a";
                i = i + 2; // skip this pattern
            } else {
                return false;
            }
        }
        if (j != str.length()) {
            return false;
        }

        if (i == pattern.length()
                || (i + 1 == pattern.length() && pattern.charAt(i) == '*')
                || (i + 2 == pattern.length() && pattern.charAt(i + 1) == '*')
                ) {
            return true;
        }

        // a ab*
        if (j > 0 && i + 2 == pattern.length() && pattern.charAt(i) == '*') { // "a*a", "a";
            return isMatch(str.substring(j - 1), pattern.substring(i + 1));
        }

        return false;
    }
}
