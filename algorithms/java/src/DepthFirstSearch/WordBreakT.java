package DepthFirstSearch;

import java.util.HashMap;
import java.util.List;

public class WordBreakT {
    class Trie {
        Trie[] children;
        boolean isWord;
        Trie() {
            children = new Trie[26];
            isWord = false;
        }
        void add(String word) {
            Trie cur = this;
            for(char ch : word.toCharArray()) {
                if(cur.children[ch-'a'] == null) {
                    cur.children[ch-'a'] = new Trie();
                }
                cur = cur.children[ch-'a'];
            }
            cur.isWord = true;
        }
    }
    Trie root;
    HashMap<String, Boolean> cache;
    // Use dfs to find words
    boolean canBreak(String s) {
        if(s.isEmpty()) return true;
        if(cache.containsKey(s)) {
            return cache.get(s);
        }
        Trie cur = root;
        int i = 0;

        // use dfs to find whether this word can break
        while(i < s.length() && cur.children[s.charAt(i)-'a'] != null) {
            cur = cur.children[s.charAt(i)-'a'];
            i++;
            if(cur.isWord && canBreak(s.substring(i))) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();
        root = new Trie();
        for(String word : wordDict) {
            root.add(word);
        }
        return canBreak(s);
    }
}
