package DepthFirstSearch;

import java.util.*;

public class ConcatenatedWords {
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
    boolean canConcatenate(String word) {
        if (word.isEmpty()) return true;
        Trie cur = root;
        int i = 0;
        while(i < word.length() && cur.children[word.charAt(i)-'a']!=null) {
            if (cur.children[word.charAt(i)-'a'].isWord && canConcatenate(word.substring(i+1))) {
                return true;
            }
            cur = cur.children[word.charAt(i)-'a'];
            i++;
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new LinkedList<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        root = new Trie();
        for (String word : words) {
            if (!word.isEmpty() && canConcatenate(word)) {
                result.add(word);
            }
            root.add(word);
        }
        return result;
    }
}
