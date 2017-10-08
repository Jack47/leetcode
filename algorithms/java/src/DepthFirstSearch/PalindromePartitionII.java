package DepthFirstSearch;

public class PalindromePartitionII {
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
    int min;

    void dfs(int startPos, int step) {
        if (isPalindrome(startPos, s.length() - 1)) {
            min = Math.min(min, step);
            return;
        }
        // stop
        if (step >= min) {
            return;
        }
        for (int k = startPos; k <= s.length() - 2; k++) {
            if (isPalindrome(startPos, k)) {
                // needs more step
                dfs(k + 1, step + 1);
            }
        }
    }

    public int minCutDfs(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        this.s = s;
        min = s.length() - 1;
        dfs(0, 0);
        return min;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // cuts[n] = cuts[0-1]+1; So we need cuts[0] to be -1;
            cuts[i] = i - 1;
        }
        for (int i = 0; i < n; i++) {
            // odd length
            for (int j = 0; j <= i && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) {
                cuts[i + j + 1] = Math.min(cuts[i + j + 1], cuts[i - j] + 1);
            }
            // even length
            for (int j = 0; j <= i - 1 && i + j < n && s.charAt(i - j - 1) == s.charAt(i + j);
                 j++) {
                cuts[i + j + 1] = Math.min(cuts[i + j + 1], cuts[i - j - 1] + 1);
            }
        }
        return cuts[n];
    }
}
