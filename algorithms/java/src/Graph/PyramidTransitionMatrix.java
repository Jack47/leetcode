package Graph;

import java.util.HashSet;
import java.util.List;

public class PyramidTransitionMatrix {
    static int MAX_CHARS = 7;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // [i][j] char
        // this can save space if the matrix is sparse
        HashSet[][] choices = new HashSet[MAX_CHARS][MAX_CHARS];
        // parse choices matrix
        for(String s : allowed) {
            char[] chs = s.toCharArray();
            int i = chs[0]-'A', j = chs[1]-'A', k = chs[2];
            if(choices[i][j] == null) {
                choices[i][j] = new HashSet<Integer>();
            }
            choices[i][j].add(k);
        }
        // use dfs to find a possible solution
        StringBuilder sb = new StringBuilder(bottom.length()-1);
        return dfs(bottom, choices, 0, sb);
    }
    boolean dfs(String base, HashSet[][] choices, int k, StringBuilder newBase) {
        if(base.length() == 1) return true;
        int i = base.charAt(k)-'A', j = base.charAt(k+1)-'A';
        HashSet<Integer> h = choices[i][j];
        if (h == null) return false;
        if(h==null || h.isEmpty()) return false;
        for(Integer ch : h) { // try all available choices
            newBase.append((char)(ch-'A'));
            if(k+1 == base.length()-1) {// cur base finished
                if(dfs(newBase.toString(), choices, 0, new StringBuilder(newBase.length()-1))) {
                    return true;
                }
            } else if(dfs(base, choices, k+1, newBase)){
                return true;
            }
            // backtrack
            newBase.deleteCharAt(newBase.length()-1);
        }
        return false;
    }
}
