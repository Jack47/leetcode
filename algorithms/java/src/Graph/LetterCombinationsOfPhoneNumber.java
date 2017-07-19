package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    List<String> result;
    StringBuilder sb;
    String digits;
    char[][] map = new char[][]{{' '}, {}, {'a', 'b', 'c'}, {'d','e','f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    void dfs(int i) {
        if(i == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int digit = digits.charAt(i) - '0';
        char[] options = map[digit];
        for(int j = 0; j < options.length; j++) {
            sb.append(options[j]);
            dfs(i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return Collections.emptyList();
        this.digits = digits;
        sb = new StringBuilder();
        result = new ArrayList<>();
        dfs(0);
        return result;
    }
}
