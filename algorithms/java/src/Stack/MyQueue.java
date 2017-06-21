package Stack;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    public void push(int x) {
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
    }
    public int pop() {
        peek();
        return s2.pop();
    }
    public int peek() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
