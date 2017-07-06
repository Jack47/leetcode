package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WordSearchT {
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

    HashSet<String> results;
    StringBuilder result;
    boolean[][] visited;
    Trie trie;
    char[][] board;
    int[][] dirs;

    void dfs(int r, int c, Trie trie) {
        char ch = this.board[r][c];
        visited[r][c] = true;
        result.append(ch);
        if (trie.isWord) {
            results.add(result.toString());
        }
        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if(newR >=0 && newR <board.length && newC >=0 && newC < board[0].length &&
                    !visited[newR][newC] && trie.children[board[newR][newC]-'a']!=null) {
                dfs(newR, newC, trie.children[board[newR][newC]-'a']);
            }
        }
        result.deleteCharAt(result.length()-1);
        visited[r][c] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) return Collections.emptyList();
        dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        results = new HashSet<>();
        result = new StringBuilder();
        visited = new boolean[board.length][board[0].length];
        trie = new Trie();
        this.board = board;
        for (String s : words) {
            trie.add(s);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (!visited[i][j] && trie.children[ch - 'a'] != null) {
                    dfs(i, j, trie.children[ch - 'a']);
                }
            }
        }

        List<String> r = new ArrayList<>();
        r.addAll(results);
        return r;
    }

}
