package DynamicProgramming;

import java.util.HashMap;
import java.util.List;

public class WordBreakDfs {
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
    Trie trie;
    HashMap<Integer, Boolean> cache;
    boolean canBreak(String s, int i) {
        if(i >= s.length()) return true;
        if(cache.containsKey(i)) return cache.get(i);
        Trie cur = this.trie;
        for(int j = i; j < s.length(); j++) {
            char ch = s.charAt(j);
            if(cur.children[ch-'a'] == null) {
                cache.put(i, false);
                return false;
            }
            if(cur.children[ch-'a'].isWord && canBreak(s, j+1)) {
                cache.put(i, true);
                return true;
            }
            cur = cur.children[ch-'a'];
        }
        cache.put(i, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        cache = new HashMap<>();
        for(String word : wordDict) {
            trie.add(word);
        }
        return canBreak(s, 0);
    }
}
