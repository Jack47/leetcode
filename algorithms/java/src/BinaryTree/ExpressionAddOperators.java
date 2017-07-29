package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    List<String> results;
    StringBuilder sb;
    int target;
    String num;

    void dfs(int pos, int curValue, int pre, int mul) {
        if (curValue == target) {
            results.add(sb.toString());
        }

        for (int i = pos; i <= num.length() - 2; i++) {
            String l = num.substring(pos, i + 1);
            int left = Integer.parseInt(l);
            if(pos == 0) {
                sb.append(l);
                dfs(i+1, curValue+left, left, left);
                sb.delete(sb.length() - l.length(), sb.length());
                continue;
            }
            sb.append('+');
            sb.append(l);
            dfs(i + 1, curValue + left, left, left); // +
            sb.delete(sb.length() - l.length(), sb.length());
            sb.deleteCharAt(sb.length() - 1);

            sb.append('-');
            sb.append(l);
            dfs(i + 1, curValue - left, -left, -left); // -
            sb.delete(sb.length() - l.length(), sb.length());
            sb.deleteCharAt(sb.length() - 1);

            sb.append('*');
            sb.append(l);
            dfs(i + 1, curValue - pre + mul * left, 0, mul * left);
            sb.delete(sb.length() - l.length(), sb.length());
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> addOperators(String num, int target) {
        results = new ArrayList<>();
        sb = new StringBuilder();
        this.target = target;
        this.num = num;
        dfs(0, 0, 0, 0);
        return results;
    }
}
