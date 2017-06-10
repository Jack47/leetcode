package StringRelated;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    boolean isDigit(String s) {
        return s.length() == 1 && s.charAt(0) >= '0' && s.charAt(0) <= '9' ||
                s.length() > 1;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        while(i < tokens.length) {
            if (isDigit(tokens[i])) {
                s.push(Integer.valueOf(tokens[i]));
            } else {
                switch (tokens[i].charAt(0)) {
                    case '+':
                        s.push(s.pop() + s.pop());
                        break;
                    case '*':
                        s.push(s.pop() * s.pop());
                        break;
                    case '-':
                        Integer op2 = s.pop();
                        Integer op1 = s.pop();
                        s.push(op1-op2);
                        break;
                    case '/':
                        op2 = s.pop();
                        op1 = s.pop();
                        s.push(op1/op2);
                        break;
                }
            }
            i++;
        }
        return s.pop();
    }
}
