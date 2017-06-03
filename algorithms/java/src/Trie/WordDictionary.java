package Trie;

class TrieNode {
    boolean isWord;
    char ch;
    TrieNode[] child;
    int LETTER_NUM = 26;

    public TrieNode() {
        isWord = false;
        ch = ' ';
        child = new TrieNode[LETTER_NUM];
    }

    public TrieNode(char ch, boolean isWord) {
        this.isWord = isWord;
        this.ch = ch;
        child = new TrieNode[LETTER_NUM];
    }

    public TrieNode getChild(int i) {
        return child[i];
    }

    public void setChild(int i, TrieNode n) {
        child[i] = n;
    }

    public void setIsWord(boolean is) {
        this.isWord = is;
    }

    public boolean getIsWord() {
        return this.isWord;
    }
}

public class WordDictionary {
    static int LETTER_NUM = 26;
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.getChild(c - 'a') == null) {
                cur.setChild(c - 'a', new TrieNode(c, false));
            }
            cur = cur.getChild(c - 'a');
        }
        cur.setIsWord(true);
    }

    public boolean search(String word) {
        if (word.length() == 0) return root.getIsWord();
        return dfs(word, 0, root);
    }

    // check whether word(i..) exists in cur
    protected boolean dfs(String word, int i, TrieNode cur) {
        // assert(cur != null);
        if (i == word.length()) {
            return cur.getIsWord();
        }

        char ch = word.charAt(i);
        if (ch != '.') {
            TrieNode c = cur.getChild(ch - 'a');
            if (c == null) return false; // ch doesn't exist
            return dfs(word, i + 1, c);
        } else {// skip this letter
            for (int k = 0; k < LETTER_NUM; k++) {
                TrieNode c = cur.getChild(k);
                if (c != null) {
                    if (dfs(word, i + 1, c)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
