package DynamicProgramming;

import java.util.*;

public class ConcatenatedWordsT {
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

    boolean canConcatenatedWord(String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) return false;
            cur = cur.children[ch - 'a'];
            if (cur.isWord && (i == word.length() - 1 || canConcatenatedWord(word.substring(i +
                    1, word.length())))) {
                return true;
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Trie();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                return w1.length() - w2.length();
            }
        });
        List<String> result = new ArrayList<>(words.length);
        for (String word : words) {
            if (canConcatenatedWord(word)) {
                result.add(word);
            }
            root.add(word);
        }
        return result;
    }
}
