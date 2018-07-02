package Graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/submissions/detail/103933662/
//
public class AlienDictionary {
    final static int LETTER_NUM = 26;

    char[] getOrder(String str1, String str2) {
        char[] ret = new char[2];
        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                ret[0] = str1.charAt(i);
                ret[1] = str2.charAt(j);
                return ret;
            }
        }
        return null;
    }

    public String alienOrder(String[] words) {
        int[] in_degree = new int[LETTER_NUM];
        boolean[] exist = new boolean[LETTER_NUM];
        int[][] matrix = new int[LETTER_NUM][LETTER_NUM];
        int count = 0;
        StringBuilder sb = new StringBuilder();

        // get adjacent matrix
        for (int i = 0; i < words.length - 1; i++) {
            char[] order = getOrder(words[i], words[i + 1]);
            if (order == null) {
                continue;
            }
            int start = order[0] - 'a';
            int end = order[1] - 'a';
            if (matrix[start][end] == 0) { // avoid duplicate edge
                in_degree[end]++;
                matrix[start][end] = 1;
            }
        }
        // add every word's letter
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < words[i].length(); k++) {
                int n = words[i].charAt(k) - 'a';
                if (!exist[n]) {
                  count++;
                  exist[n] = true;
                }
            }
        }
        // topology sort
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < in_degree.length; i++) {
            if (in_degree[i] == 0 && exist[i]) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer n = q.poll();
            sb.append((char) (n + 'a'));
            count--;
            for (int j = 0; j < matrix[n].length; j++) {
                if (matrix[n][j] != 0) {
                    in_degree[j]--;
                    if (in_degree[j] == 0) {
                        q.add(j);
                    }
                }
            }
        }
        if (count != 0) {
           return "";
        }
        return sb.toString();
    }

}
