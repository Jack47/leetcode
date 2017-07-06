package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionaryT {
    int[][] construct(String[] words) {
        int[][] matrix = new int[26][26];
        this.inDegree = new int[matrix.length];
        this.hasChar = new boolean[matrix.length];

        for (int i = 0; i <= words.length - 2; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int j = 0, k = 0;
            while (j < w1.length() && k < w2.length() && w1.charAt(j) == w2.charAt(k)) {
                j++;
                k++;
            }
            if (j < w1.length() && k == w2.length()) return null;
            if (j < w1.length() && k < w2.length()) {
                int ch1 = w1.charAt(j) - 'a';
                int ch2 = w2.charAt(k) - 'a';
                if(matrix[ch1][ch2] != 1) {
                    matrix[ch1][ch2] = 1;
                    inDegree[ch2]++;
                }

                if (matrix[ch2][ch1] == 1) { // there is direct cycle
                    return null;
                }
            }
        }
        for(String w : words) {
            for(char ch : w.toCharArray()) {
                hasChar[ch-'a'] = true;
            }
        }
        for(boolean has : hasChar) {
            if(has) {
                charCount++;
            }
        }
        return matrix;
    }

    int[][] matrix;
    boolean[] hasChar;
    int charCount;
    StringBuilder result;
    int[] inDegree;

    public String alienOrder(String[] words) {
        charCount = 0;
        matrix = construct(words);
        result = new StringBuilder();

        if(matrix == null) {
            return result.toString();
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0 && hasChar[i]) {
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int c = q.poll();
            result.append((char)(c+'a'));
            count++;
            for(int i = 0; i < inDegree.length; i++) {
                if(matrix[c][i] > 0) {
                    inDegree[i]--;
                    if(inDegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }

        return count == charCount ? result.toString() : "";
    }
}
