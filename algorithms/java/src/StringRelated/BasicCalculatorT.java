package StringRelated;

import java.util.Stack;

public class BasicCalculatorT {
    class State {
        char op;
        int prev;
        int ret;
        public State(int ret, int prev, char op) {
            this.op = op;
            this.prev = prev;
            this.ret = ret;
        }
    }
    public int calculate(String s) {
        State state = new State(0, 0, '+');
        int i = 0;
        Stack<State> stack = new Stack<State>();
        while (i < s.length()) {
            if ("+-".indexOf(s.charAt(i)) >= 0) {
                state.op = s.charAt(i);
            } else if ('(' == s.charAt(i)) {
                stack.push(state);
                state = new State(0, 0, '+');
            } else if (')' == s.charAt(i)) {
                State prev = stack.pop();
                cal(prev, state.ret);
                state = prev;
            } else if (Character.isDigit(s.charAt(i))) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val += val * 10 + s.charAt(i) - '0';
                    i++;
                }
                cal(state, val);
                continue;
            }
            i++;
        }
        return state.ret;
    }

    void cal(State state, int val) {
        if ("+-".indexOf(state.op) >= 0) {
            state.prev = state.op == '-' ? -val : val;
        } else {
            state.prev = state.op == '*' ? state.prev * val : state.prev / val;
        }
        state.ret += state.prev;
    }
}
