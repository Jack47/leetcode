package DepthFirstSearch;

import java.util.*;

public class PalindromePartition {
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

    List<List<String>>[] cache;
    String s;

    // NOTE s.length > 0
    List<List<String>> dfs(int i) {
        if (cache[i] != null) return cache[i];
        List<List<String>> ret = new LinkedList<>();

        if (isPalindrome(i, s.length() - 1)) {
            List<String> result = new LinkedList<>();
            result.add(s.substring(i));
            ret.add(result);
        }
        if (i == s.length() - 1) {// length == 1
            cache[i] = ret;
            return ret;
        }

        // partition s[i..j] to non empty substrings
        for (int k = i; k <= s.length() - 2; k++) {
            if (isPalindrome(i, k)) {
                List<List<String>> ret2 = dfs(k + 1);
                for (List<String> r2 : ret2) {
                    List<String> result = new ArrayList<>();
                    result.add(s.substring(i, k));
                    result.addAll(r2);
                    ret.add(result);
                }
            }
        }
        cache[i] = ret;
        return ret;
    }

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return Collections.emptyList();
        cache = new List[s.length()];
        this.s = s;
        return dfs(0);
    }
}
