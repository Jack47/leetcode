package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        char[] para = new char[]{'(', ')'};
        remove(s, 0, 0, para, ans);
        return ans;
    }

    void remove(String s, int lastI, int lastJ, char[] para, List<String> ans) {
        int count = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == para[0]) {
                count++;
            }
            if (s.charAt(i) == para[1]) {
                count--;
            }
            if (count < 0) {
                for (int j = lastJ; j <= i; j++) {
                    if (s.charAt(j) == para[1] &&(j == 0 || s.charAt(j - 1) != para[1])) {
                        remove(s.substring(0, j) + s.substring(j + 1), i, j, para, ans);
                    }
                }
                return;
            }
        }
        // finished remove invalid parentheses
        String reversed = new StringBuilder(s).reverse().toString();
        if(para[0] == '(') {
            remove(reversed, 0, 0, new char[] {')', '('}, ans);
        } else {
            ans.add(reversed);
        }
    }
}
