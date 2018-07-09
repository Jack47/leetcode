package DepthFirstSearch;

import java.util.HashSet;

// airbnb code
public class  WordSearchIIE {
    // find the maximum words which can be formed by a path
    // 找出一条path包含最多的存在于字典的word个数
    boolean[][] visited; // prevent dead loops
    HashSet<String> result;
    char[][] board;
    int max;
    TrieNode root;

    public int findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        this.board = board;
        root = new TrieNode();
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
                    dfs(root, i, j, sb);
                    visited[i][j] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return max;
    }

    // start from board[i][j], try to go to word[k]
    void dfs(TrieNode root, int i, int j, StringBuilder sb) {
        boolean foundWord = false;
        if(root.isLeaf) {
            result.add(sb.toString());
            max  = Math.max(max, result.size());
            // two choices:
            // 1. start another word from here
            // 2. continue

            // 1.

            for(int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if(ni >= 0 && ni < board.length &&
                        nj >= 0 && nj < board[0].length &&
                        !visited[ni][nj]) {
                           char ch = board[ni][nj];
                           if(this.root.trieNodes[ch-'a'] != null) {
                               dfs(this.root.trieNodes[ch-'a'], ni, nj, new StringBuilder());
                           }
                        }
            }
        }

        // 2.
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

    static int[][] directions = new int[][]{{-2, 0}, {1,0},{0,1},{0,-1}};
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
