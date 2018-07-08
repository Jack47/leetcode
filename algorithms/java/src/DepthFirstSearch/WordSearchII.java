package DepthFirstSearch;

import java.util.LinkedList;
import java.util.List;

public class WordSearchII {
    boolean[][] visited; // prevent dead loops
    List<String> result;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        result = new LinkedList<String>();
        this.board = board;
        TrieNode root = new TrieNode();
        for(String word: words) {
            root.insert(word);
        }
        visited = new boolean[board.length][board[0].length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if(root.trieNodes[ch-'a']!=null) {
                    visited[i][j] = true;
                    sb.append(ch);
                    dfs(root.trieNodes[ch-'a'], i, j, sb);
                    visited[i][j] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return result;
    }
    // start from board[i][j], try to go to word[k]
    void dfs(TrieNode root, int i, int j, StringBuilder sb) {
        if(root.isLeaf) {
            result.add(sb.toString());
        }
        for(int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && ni < board.length &&
                    nj >= 0 && nj < board[0].length &&
                    root.trieNodes[board[ni][nj]-'a']!=null && !visited[ni][nj]) {
                visited[ni][nj] = true;
                sb.append(board[ni][nj]);
                dfs(root.trieNodes[board[ni][nj]-'a'], ni, nj, sb);
                sb.deleteCharAt(sb.length()-1);
                visited[ni][nj] = false;
            }
        }
    }
    static int[][] directions = new int[][]{{-1, 0}, {1,0},{0,1},{0,-1}};
    class TrieNode {
        TrieNode[] trieNodes;
        boolean isLeaf;
        public TrieNode() {
            trieNodes = new TrieNode[26];
        }
        void insert(String word) {
            TrieNode cur = this;
            for(char ch : word.toCharArray()) {
                if(cur.trieNodes[ch-'a']==null) {
                    cur.trieNodes[ch-'a'] = new TrieNode();
                }
                cur = cur.trieNodes[ch-'a'];
            }
            cur.isLeaf = true;
        }
    }
}
