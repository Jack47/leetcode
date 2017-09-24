package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesesT {
    List<String> answer;

    public List<String> removeInvalidParentheses(String s) {
        answer = new ArrayList<>();
        remove(s, 0, 0, new char[]{'(', ')'});
        return answer;
    }

    // use dfs to visit s[i..n],    toRemove <= i;
    // remove invalid paras[1] start from toRemove
    void remove(String s, int i, int toRemove, char[] paras) {
        int count = 0;
        for (int k = i; k < s.length(); k++) {
            if (s.charAt(k) == paras[0]) {
                count++;
            } else if (s.charAt(k) == paras[1]) {
                count--;
            }
            if (count >= 0) continue; // only dealing with excessive paras[1]
            // Try out every possible remove of excessive [1]
            for (int j = toRemove; j <= k; j++) {
                if (s.charAt(j) == paras[1] && (j == toRemove || s.charAt(j - 1) != paras[1])) {
                    remove(s.substring(i, j) + s.substring(j + 1), k, j, paras);
                }
            }
            return; // count < 0, so just return. we've already tried to recover
        }
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        if (paras[0] == '(') {
            // we only checked from left to right
            // we still need to check the right to left.
            remove(s, 0, 0, new char[]{')', '('});
        } else {
            // count of '(' >= count of ')'
            // count of ')' >= count of '('
            // so count of '(' == ')'
            answer.add(s);
        }
    }
}
