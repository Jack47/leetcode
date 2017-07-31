package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    List<String> results;
    int target;
    String num;

    void dfs(int pos, String curResult, long curValue, long pre, long mul) {
        if (curValue == target && pos == num.length()) {
            results.add(curResult);
        }

        for (int i = pos; i <= num.length() - 1; i++) {
            if(num.charAt(pos) == '0' && i > pos) break; // avoid leading zero
            String l = num.substring(pos, i + 1);
            long left = Long.parseLong(l);
            if(pos == 0) { // it's the beginning, so can not add operator
                dfs(i+1, curResult+l, curValue+left, left, left);
                continue;
            }
            dfs(i + 1, curResult + '+' + l, curValue + left, left, left); // +
            dfs(i + 1, curResult + '-' + l, curValue - left, -left, -left); // -
            dfs(i + 1, curResult + '*' + l, curValue - pre + mul * left, mul*left, mul * left);
        }
    }

    public List<String> addOperators(String num, int target) {
        results = new ArrayList<>();
        this.target = target;
        this.num = num;
        dfs(0, "", 0, 0, 0);
        return results;
    }
}
