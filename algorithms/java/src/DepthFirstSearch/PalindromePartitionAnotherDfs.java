package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitionAnotherDfs {
    // NOTE s.length() >= 1;
    boolean isPalindrome(int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    String s;
    List<String> cur;
    List<List<String>> result;

    // NOTE s.length > 0
    void dfs(int startPos) {
        if (startPos == s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int k = startPos; k <= s.length() - 1; k++) {
            if (isPalindrome(startPos, k)) {
                cur.add(s.substring(startPos, k + 1));
                dfs(k + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return Collections.emptyList();
        this.s = s;
        cur = new LinkedList<>();
        result = new LinkedList<>();
        dfs(0);
        return result;
    }
}
