package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifferentWaysToAddParentheses {
    HashMap<String, List<Integer>> cache;
    List<Integer> dfs(String str) {
        if(cache.containsKey(str)) {
            return cache.get(str);
        }
        List<Integer> results = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            if ("+-*".indexOf(str.charAt(i)) >= 0) {
                List<Integer> lefts = dfs(str.substring(0, i));
                List<Integer> rights = dfs(str.substring(i + 1));
                for (Integer left : lefts) {
                    for (Integer right : rights) {
                        int result = 0;
                        switch (str.charAt(i)) {
                            case '+':
                                result = left + right;
                                break;
                            case '-':
                                result = left - right;
                                break;
                            case '*':
                                result = left * right;
                                break;
                        }
                        results.add(result);
                    }
                }
            }
            i++;
        }
        if (results.isEmpty()) {
            results.add(Integer.parseInt(str));
        }
        cache.put(str, results);
        return results;
    }

    public List<Integer> diffWaysToCompute(String input) {
        cache = new HashMap<>();
        return dfs(input);
    }
}
