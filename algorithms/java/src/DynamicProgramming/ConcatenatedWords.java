package DynamicProgramming;

import java.util.*;

class ConcatenatedWordsEnhancement {
    class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
            isWord = false;
        }

        void add(String word) {
            Trie cur = this;
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Trie();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.isWord = true;
        }
    }

    Trie trie;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        trie = new Trie();
        for (String s : words) {
            if (canConcat(s)) {
                result.add(s);
            }
            trie.add(s);
        }
        return result;
    }

    boolean canConcat(String s) {
        if (s.isEmpty()) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            Trie cur = trie;
            for (int j = i; j <= s.length() - 1; j++) {
                if (cur.children[s.charAt(j) - 'a'] != null) {
                    if (dp[j + 1] && cur.children[s.charAt(j) - 'a'].isWord) {
                        dp[i] = true;
                        break;
                    }
                    cur = cur.children[s.charAt(j)-'a'];
                } else {
                    break; // prefix don't fit, don't need to search any more
                }
            }
        }
        return dp[0];
    }
}

public class ConcatenatedWords {
    HashSet<String> dict;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        dict = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String s : words) {
            if (canConcat(s)) {
                result.add(s);
            }
            dict.add(s);
        }
        return result;
    }

    boolean canConcat(String s) {
        if (s.isEmpty()) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String t = s.substring(j, i);
                if (dp[j] && dict.contains(t)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
