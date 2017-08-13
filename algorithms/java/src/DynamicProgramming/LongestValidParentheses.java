package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        if (s.indexOf(')') < 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>(s.length());
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                stack.pop();
                if (stack.isEmpty()) { // not valid, push new pre starting point
                    stack.push(i);
                } else {
                    int j = stack.peek();
                    max = Math.max(max, i - j);
                }
            }
        }
        return max;
    }
}