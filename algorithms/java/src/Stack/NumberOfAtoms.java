package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfAtoms {
    String convertToString(TreeMap<String, Long> atoms) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Long> entry : atoms.entrySet()) {
            String atom = entry.getKey();
            Long count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(Long.toString(count));
            }
        }
        return sb.toString();
    }

    void merge(TreeMap<String, Long> src, TreeMap<String, Long> dst) {
        for (Map.Entry<String, Long> entry : src.entrySet()) {
            dst.put(entry.getKey(), entry.getValue() + dst.getOrDefault(entry.getKey(), 0L));
        }
    }

    void multiple(TreeMap<String, Long> src, Long count) {
        for (Map.Entry<String, Long> entry : src.entrySet()) {
            src.put(entry.getKey(), entry.getValue() * count);
        }
    }

    public String countOfAtoms(String formula) {
        Deque<TreeMap<String, Long>> stack = new ArrayDeque<>();
        int i = 0;
        char[] chars = formula.toCharArray();
        TreeMap<String, Long> cur = new TreeMap<>();

        while (i < chars.length) {
            if (chars[i] == '(') {
                stack.push(cur); // store the cur node, because new item occurs
                cur = new TreeMap<>();
                i++;
            } else if (chars[i] == ')') { // cur item ends, multiple it and join it with previous
                long count = 1; // default value
                i++;
                if (i < chars.length && Character.isDigit(chars[i])) {
                    count = 0;
                    while (i < chars.length && Character.isDigit(chars[i])) {
                        count = count * 10 + chars[i] - '0';
                        i++;
                    }
                }
                if (count > 1) {
                    multiple(cur, count);
                }

                if (!stack.isEmpty()) {
                    TreeMap<String, Long> top = stack.pop();
                    merge(top, cur);
                }
            } else if (Character.isUpperCase(chars[i])) {
                int start = i;
                i++;
                while (i < chars.length && Character.isLowerCase(chars[i])) {
                    i++;
                }
                int end = i;
                int count = 1;
                if (i < chars.length && Character.isDigit(chars[i])) {
                    count = 0;
                    while (i < chars.length && Character.isDigit(chars[i])) {
                        count = 10 * count + chars[i] - '0';
                        i++;
                    }
                }
                String key = formula.substring(start, end);
                cur.put(key, count + cur.getOrDefault(key, 0L));
            } else { // == '(' && cur.size == 0;    ==')'
                i++;
            }
        }

        assert (stack.isEmpty());
        return convertToString(cur);
    }
}
