package DynamicProgramming;

import java.util.HashSet;
import java.util.List;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> dicts = new HashSet<>();
        int maxLen = 0;
        for(String str : wordDict) {
            maxLen = Math.max(maxLen, str.length());
            dicts.add(str);
        }
        dp[0] = true;
        for(int i = 1; i <= s.length();i++) {
            // calculate dp[i]
            // dp[i] represent endin at i-1 is breakable
            for(int j = i-1; j >= 0 && i-j <= maxLen; j--) { // [j..i]
                if(dp[j] && dicts.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
