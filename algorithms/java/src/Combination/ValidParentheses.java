package Combination;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (isLeftParenthesis(c)) {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                Character prev = stack.pop();
                if (!isParenthesisMatch(prev, c)) return false;
            }
        }

        return stack.size() == 0;
    }

    protected boolean isLeftParenthesis(Character c) {
        if (c == '{' || c == '[' || c == '(') return true;
        else return false;
    }

    protected boolean isParenthesisMatch(Character left, Character right) {
        switch (left) {
            case '{':
                return right == '}';
            case '[':
                return right == ']';
            case '(':
                return right == ')';
        }
        return false;
    }
}
