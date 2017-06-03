package Trie;

// https://leetcode.com/problems/implement-trie-prefix-tree/#/description
class TTrieNode {
    protected static int LETTER_NUM = 26;
    TTrieNode[] child;
    char ch;
    boolean isWord;

    public TTrieNode(char ch, boolean isWord){
        child = new TTrieNode[LETTER_NUM];
        this.isWord = isWord;
        this.ch = ch;
    }
    public TTrieNode() {
        child = new TTrieNode[LETTER_NUM];
        this.isWord = false;
        this.ch = ' ';
    }
    public boolean isWord() {
        return isWord;
    }
    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
    public TTrieNode getChild(int i) {
        return child[i];
    }
    public void setChild(int i, TTrieNode node) {
        child[i] = node;
    }
}

public class Trie {
    TTrieNode root;
    public Trie() {
        root = new TTrieNode();
    }
    public void insert(String word) {
        TTrieNode cur = root;
        for(char c : word.toCharArray()) {
            if (cur.getChild(c-'a') == null) {
                cur.setChild(c-'a', new TTrieNode(c, false));
            }
            cur = cur.getChild(c-'a');
        }
        cur.setIsWord(true);
    }
    public boolean search(String word) {
        TTrieNode cur = root;
        for(char c : word.toCharArray()) {
            cur = cur.getChild(c-'a');
            if (cur == null) return false;
        }
        if (cur.isWord()) return true;
        return false;
    }
    public boolean startsWith(String prefix) {
        TTrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            cur = cur.getChild(c-'a');
            if (cur == null) return false;
        }
        return true;
    }
}