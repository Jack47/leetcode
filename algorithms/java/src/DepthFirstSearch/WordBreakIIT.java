package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WordBreakIIT {
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

    Trie root;
    HashMap<String, List<String>> cache;

    // Use dfs to find words
    List<String> breakStr(String s) {
        if (s.isEmpty()) return Collections.emptyList();
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        Trie cur = root;
        int i = 0;
        List<String> ret = new ArrayList<>();
        // use dfs to find whether this word can break
        while (i < s.length() && cur.children[s.charAt(i) - 'a'] != null) {
            cur = cur.children[s.charAt(i) - 'a'];
            if (cur.isWord) {
                List<String> result = breakStr(s.substring(i + 1));
                for (String r : result) {
                    String str = s.substring(0, i + 1) + (r.isEmpty() ? "" : (" " + r));
                    ret.add(str);
                }
            }
            i++;
        }
        cache.put(s, ret);
        return ret;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();
        root = new Trie();
        for (String word : wordDict) {
            root.add(word);
        }
        return breakStr(s);
    }
}
